package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIServiceleavetaken;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.leavetakenarrayadapter.LeaveTakenArrayAdapter;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.model.UserLeaveTaken;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.model.UserLeaveTaken;

public class LeaveTakenDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<UserLeaveTaken> data;
    private LeaveTakenArrayAdapter adapter;
    private static final String TAG = "LeaveTAkenDetails";
    private Button buttonstartdate;
    private Button buttonenddate;
    private Button buttonsendleavetaken;
    Login eidleavetakendetails;
    String begintime;
    String endtime;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;
    private DatePickerDialog.OnDateSetListener mDateSetListner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_taken_details);

        buttonstartdate = (Button) findViewById(R.id.begintimeleavetaken);
        buttonenddate = (Button) findViewById(R.id.endtimeleavetaken);


        begintimeleavetaken();
        endtimeleavetaken();

        buttonsendleavetaken = (Button)findViewById(R.id.buttonsendleavetaken) ;
        buttonsendleavetaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(begintime == null || endtime == null)
                {
                    Toast.makeText(LeaveTakenDetails.this,"Please select start date and end date",Toast.LENGTH_LONG).show();
                }else
                {
                    String eid  = eidleavetakendetails.EIDemployee;

                    recyclerView = (RecyclerView) findViewById(R.id.item_list);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(APIUrlLeavetaken.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIServiceleavetaken service = retrofit.create(APIServiceleavetaken.class);

                    Call<List<UserLeaveTaken>> call = service.gettakenleave(eid,begintime,endtime);

                    call.enqueue(new Callback<List<UserLeaveTaken>>() {
                        @Override
                        public void onResponse(Call<List<UserLeaveTaken>> call, Response<List<UserLeaveTaken>> response) {

                           if(response.isSuccessful())
                           {
                               Toast.makeText(LeaveTakenDetails.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                               data = (ArrayList<UserLeaveTaken>)response.body();
                               adapter = new LeaveTakenArrayAdapter(data, LeaveTakenDetails.this);
                               recyclerView.setAdapter(adapter);


                           }
                        }

                        @Override
                        public void onFailure(Call<List<UserLeaveTaken>> call, Throwable t) {

                            Toast.makeText(LeaveTakenDetails.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

    }

    public void begintimeleavetaken() {


        buttonstartdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        LeaveTakenDetails.this,
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
                String date = year + "-" + month + "-" + day;
                buttonstartdate.setText(date);
                begintime = date;
            }
        };
    }

    private void endtimeleavetaken() {


        buttonenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        LeaveTakenDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        mDateSetListner2,
                        year,month,day);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });

        mDateSetListner2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = year + "-" + month + "-" + day;
                buttonenddate.setText(date);
                endtime = date;
            }
        };
    }

   // private void viewleavetakendata() {}
}





