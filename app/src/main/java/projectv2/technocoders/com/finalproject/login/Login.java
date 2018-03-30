package projectv2.technocoders.com.finalproject.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projectv2.technocoders.com.finalproject.LocalStore;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.MainActivity;
import projectv2.technocoders.com.finalproject.home.Navigation1;
import projectv2.technocoders.com.finalproject.home2.Navigation2;
import projectv2.technocoders.com.finalproject.login.model.ResObj;
import projectv2.technocoders.com.finalproject.login.remote.ApiUtils;
import projectv2.technocoders.com.finalproject.login.remote.SessionManager;
import projectv2.technocoders.com.finalproject.login.remote.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText editemail;
    EditText editPassword;
    Button btnlogin;
    UserService mauserService;
    public static String EIDemployee;
    LocalStore localStore;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editemail= (EditText) findViewById(R.id.editemail);
        editPassword= (EditText) findViewById(R.id.editPassword);
        btnlogin= (Button) findViewById(R.id.btnlogin);

        mauserService= ApiUtils.getUserService();

        localStore = new LocalStore(getApplicationContext());

        if (localStore.getUserLoggedIn()) {
            // User is already logged in. Take him to main activity

            ResObj r = localStore.getUserDetails();

            if(r.getJobCategory().equals("Non-Managerial")){
                Intent intent=new Intent(Login.this, Navigation1.class);
                intent.putExtra("email",r.getEmail());
                startActivity(intent);
            }

            else{ Intent intent=new Intent(Login.this,Navigation2.class);
                intent.putExtra("email",r.getEmail());
                startActivity(intent);}
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editemail.getText().toString();
                String password=editPassword.getText().toString();
                if(validateLogin (email, password)){

                    sendPost(email, password);

                }
            }
        });
    }
    private boolean validateLogin(String email,String Password){

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        email=editemail.getText().toString();
        Matcher matcher= Pattern.compile(emailPattern).matcher(email);

        if(email==null || email.trim().length()==0|| !matcher.matches()){
            Toast.makeText(this, "email is required" ,Toast.LENGTH_SHORT).show();
            return false;


        }

        if(Password==null || Password.trim().length()==0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;



    }

    private  void  sendPost(final String email, final String password){
        pDialog = new ProgressDialog(this);

        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        mauserService.savePost(email,password).enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                hidePDialog();

                if(response.isSuccessful()){
                    ResObj resObj=response.body();
                   String eidemployee= resObj.getEID();
                    Login.EIDemployee = eidemployee;

                    //adding to shared preferences

                    if(resObj.getEID().equals(null)){

                        Toast.makeText(Login.this,"email or password is incorrect",Toast.LENGTH_SHORT).show();

                    }else {
                         //Toast.makeText(Login.this, "success",
                        // Toast.LENGTH_LONG).show();
                        localStore = new LocalStore(getApplicationContext());
                        localStore.setUserDetails(resObj);
                        localStore.setUserLoggedIn(true);

                        if(resObj.getJobCategory().equals("Non-Managerial")){
                            Intent intent=new Intent(Login.this, Navigation1.class);
                            intent.putExtra("email",email);
                            startActivity(intent);
                        }

                        else{ Intent intent=new Intent(Login.this,Navigation2.class);
                            intent.putExtra("email",email);
                            startActivity(intent);}

                    }
                }
                else {
                    Toast.makeText(Login.this,"email or password is incorrect",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResObj> call, Throwable t) {
                hidePDialog();
                Toast.makeText(Login.this,"Error,Please try again",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
