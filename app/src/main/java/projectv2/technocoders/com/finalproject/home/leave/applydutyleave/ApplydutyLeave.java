package projectv2.technocoders.com.finalproject.home.leave.applydutyleave;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.applydutyleave.api.APIService;
import projectv2.technocoders.com.finalproject.home.leave.applydutyleave.api.APIUrl;
import projectv2.technocoders.com.finalproject.home.leave.applydutyleave.models.User;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplydutyLeave extends AppCompatActivity {

    private Button buttondate;
    private Button buttonBeginTime;
    private Button buttonEndTime;
    private EditText editTextLocation;
    private EditText editTextPurpose;
    private Button buttonSend;
    Login eiddutyleave;
    String begintime;
    String dutyleavedate;
    String dutyleaveendtime;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyduty_leave);

        buttonEndTime = (Button)findViewById(R.id.buttonEndTime);
        buttonBeginTime = (Button)findViewById(R.id.buttonBeginTime);
        buttondate = (Button) findViewById(R.id.buttondate);
        editTextLocation = (EditText)findViewById(R.id.editTextLocation);
        editTextPurpose = (EditText)findViewById(R.id.editTextPurpose);

        dutyleavedate();

        dutyleavebegintime();

        dutyleaveendtime();

        buttonSend = (Button)findViewById(R.id.ButtonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ApplydutyLeave.this,"Sending",Toast.LENGTH_SHORT).show();

                String endtime = dutyleaveendtime;
                String appointment_time = begintime;
                String date = dutyleavedate;
                String location = editTextLocation.getText().toString();
                String purpose = editTextPurpose.getText().toString();
                String eid = eiddutyleave.EIDemployee;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrl.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                User user = new User(eid, date, appointment_time, location, endtime, purpose);

                Call<User> call = service.createUser(

                        user.getEID(),
                        user.getDate(),
                        user.getLocation(),
                        user.getAppointment_time(),
                        user.getEndTime(),
                        user.getPurpose()

                );
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(ApplydutyLeave.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                        Toast.makeText(ApplydutyLeave.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    private void dutyleavedate() {

        buttondate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        ApplydutyLeave.this,
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
                buttondate.setText(date);
                dutyleavedate = date;
            }
        };

    }

    private void dutyleavebegintime() {

        buttonBeginTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int hour = cal1.get(Calendar.HOUR_OF_DAY);
                int minute = cal1.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        ApplydutyLeave.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {

                        String time = hourofDay+":"+minute;
                        buttonBeginTime.setText(time);
                        begintime = time;
                    }
                }, hour, minute, true);
                timePickerDialog.show();

            }
        });
    }

    private void dutyleaveendtime() {


        buttonEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int hour = cal1.get(Calendar.HOUR_OF_DAY);
                int minute = cal1.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog1 = new TimePickerDialog(
                        ApplydutyLeave.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {

                        String time = hourofDay+":"+minute;
                        buttonEndTime.setText(time);
                        dutyleaveendtime = time;
                    }
                }, hour, minute, true);
                timePickerDialog1.show();

            }
        });
    }
}
