package projectv2.technocoders.com.finalproject.home.attendance.attendancereports;

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
import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.api.APIService_Attd_Details;
import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.attendancedetailsarrayadapter.At_details_ArrayAdapter;
import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.model.Attendance_details_model;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AttendanceDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Attendance_details_model> data;
    private At_details_ArrayAdapter adapter;
    private static final String TAG = "AttendanceDetails";
    private Button buttonstartdate;
    private Button buttonenddate;
    private Button buttonsendattendancedata;
    Login eidattendancedata;
    String begintime;
    String endtime;
    boolean beginclick = false;
    boolean endclick = false;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;
    private DatePickerDialog.OnDateSetListener mDateSetListner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_details);

        buttonstartdate = (Button) findViewById(R.id.begintimeattendancedetails);
        buttonenddate = (Button) findViewById(R.id.endtimeattendancedetails);

        begintimeattData();
        endtimeattData();

        buttonsendattendancedata  = (Button)findViewById(R.id.buttonsendattendancedetails) ;

        buttonsendattendancedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(begintime == null || endtime == null)
                {
                    Toast.makeText(AttendanceDetails.this,"Please select start date and end date",Toast.LENGTH_LONG).show();
                }else
                {
                    String eid  = eidattendancedata.EIDemployee;

                    recyclerView = (RecyclerView) findViewById(R.id.item_list_attendancedetails);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(APIUrlLeavetaken.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIService_Attd_Details service = retrofit.create(APIService_Attd_Details.class);

                    retrofit2.Call<List<Attendance_details_model>> call = service.getattendanceData(eid, begintime,endtime);

                    call.enqueue(new Callback<List<Attendance_details_model>>() {
                        @Override
                        public void onResponse(retrofit2.Call<List<Attendance_details_model>> call, Response<List<Attendance_details_model>> response) {

                            Toast.makeText(AttendanceDetails.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                            data = (ArrayList<Attendance_details_model>)response.body();
                            adapter = new At_details_ArrayAdapter(data, AttendanceDetails.this);
                            recyclerView.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(retrofit2.Call<List<Attendance_details_model>> call, Throwable t) {

                            Toast.makeText(AttendanceDetails.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

                        }
                    });
                }

            }
        });

    }

    private void begintimeattData() {

        buttonstartdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        AttendanceDetails.this,
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


    private void endtimeattData() {

        buttonenddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog2 = new DatePickerDialog(
                        AttendanceDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        mDateSetListner2,
                        year,month,day);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
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
}
