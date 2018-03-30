package projectv2.technocoders.com.finalproject.home.leave.applyleave;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import projectv2.technocoders.com.finalproject.LocalStore;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.applyleave.api.APIServiceleave;
import projectv2.technocoders.com.finalproject.home.leave.applyleave.api.APIUrlleave;
import projectv2.technocoders.com.finalproject.home.leave.applyleave.models.UserLeave;
import projectv2.technocoders.com.finalproject.login.Login;
import projectv2.technocoders.com.finalproject.login.model.ResObj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplyLeave extends AppCompatActivity {


    private Button buttonleaveDate;
    private EditText editTextReason;
    private Button buttonLeaveSend;
    String leavecategory;
    Login eidleave;
    String leavedate;
    private DatabaseReference mRootRef;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);

        mRootRef = FirebaseDatabase.getInstance().getReference();

        buttonleaveDate = (Button) findViewById(R.id.buttonleaveDate);
        editTextReason = (EditText)findViewById(R.id.editTextReason);

        buttongetdate();

        Spinner mySpinner  = (Spinner)findViewById(R.id.SpinnerLeaveCategory);
        ArrayAdapter<String>  myAdapter = new ArrayAdapter<String>(ApplyLeave.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.leavetypes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 1: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 2: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 3: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 4: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    default:break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonLeaveSend = (Button)findViewById(R.id.ButtonLeaveSend);

        buttonLeaveSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ApplyLeave.this,"Sending",Toast.LENGTH_SHORT).show();

                // String date = leavedate;
                String reason = editTextReason.getText().toString();
                // String leave_category = leavecategory;
                String eid = eidleave.EIDemployee;



                UserLeave user = new UserLeave(eid,leavedate,reason,leavecategory);
                LocalStore localStore = new LocalStore(getApplicationContext());
                ResObj resObj = localStore.getUserDetails();;

                Toast.makeText(ApplyLeave.this,resObj.getEID(),Toast.LENGTH_SHORT).show();
                String notificationReceiverRef = "notifications/" + "employeeLeave/" + resObj.getManagerId() + "/" + resObj.getEID();

                Map messageMapReceiver = new HashMap();
                messageMapReceiver.put("employeeName",resObj.getFName());
                messageMapReceiver.put("date",user.getDate());
                messageMapReceiver.put("reason",user.getReason());
                messageMapReceiver.put("leaveCtaegory", user.getLeavecategory());

                Map messageUserMap = new HashMap();
                messageUserMap.put(notificationReceiverRef, messageMapReceiver);

                mRootRef.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if(databaseError != null){
                            Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlleave.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIServiceleave service = retrofit.create(APIServiceleave.class);

                retrofit2.Call<UserLeave> call = service.createUser(

                        user.getEID(),
                        user.getDate(),
                        user.getLeavecategory(),
                        user.getReason()


                );

                call.enqueue(new Callback<UserLeave>() {
                    @Override
                    public void onResponse(Call<UserLeave> call, Response<UserLeave> response) {
                        Toast.makeText(ApplyLeave.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<UserLeave> call, Throwable t) {

                        Toast.makeText(ApplyLeave.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


    }

    private void buttongetdate() {

        buttonleaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        ApplyLeave.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        mDateSetListner1,
                        year,month,day);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });

        mDateSetListner1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String mt,dy;
                if(month < 10 )
                    mt = "0"+month;
                else mt = String.valueOf(month);

                if(day < 10)
                    dy = "0"+day;
                else dy = String.valueOf(day);

                String date = year + "-" + mt + "-" + dy;
                buttonleaveDate.setText(date);
                leavedate = date;
            }
        };

    }


}
