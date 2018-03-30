package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data;

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
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.api.APIService_viewEmployeeAttdata;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.model.ViewEmployeeAttData_model;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.viewemployeeatt_Arrayadapter.ViewEmployeeAtt_Arrayadapter;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewEmployeeAtt_data extends AppCompatActivity {


    RecyclerView recyclerView;
    private ArrayList<ViewEmployeeAttData_model> data;
    private ViewEmployeeAtt_Arrayadapter adapter;
    private static final String TAG = "AttendanceDetails";
    private Button buttonstartdate;
    private Button buttonenddate;
    private Button buttonsendviewattendancedata;
    Login eidviewEMPattendancedata;
    String begintime;
    String endtime;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;
    private DatePickerDialog.OnDateSetListener mDateSetListner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee_att_data);


        buttonstartdate = (Button) findViewById(R.id.begintimeviewEMPattendance);
        buttonenddate = (Button) findViewById(R.id.endtimeviewEMPattendance);

        begintimeattData();
        endtimeattData();

        buttonsendviewattendancedata  = (Button)findViewById(R.id.buttonsendviewEMPattendance);

        buttonsendviewattendancedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(begintime == null || endtime == null)
                {
                    Toast.makeText(ViewEmployeeAtt_data.this,"Please select start date and end date",Toast.LENGTH_LONG).show();
                }else {

                    String eid  = eidviewEMPattendancedata.EIDemployee;

                    recyclerView = (RecyclerView) findViewById(R.id.item_list_viewEMP_attendance);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(APIUrlLeavetaken.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIService_viewEmployeeAttdata service = retrofit.create(APIService_viewEmployeeAttdata.class);

                    Call<List<ViewEmployeeAttData_model>> call = service.getviewEMPattendanceData(eid,begintime,endtime);

                    call.enqueue(new Callback<List<ViewEmployeeAttData_model>>() {
                        @Override
                        public void onResponse(Call<List<ViewEmployeeAttData_model>> call, Response<List<ViewEmployeeAttData_model>> response) {

                            Toast.makeText(ViewEmployeeAtt_data.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                            data = (ArrayList<ViewEmployeeAttData_model>)response.body();
                            adapter = new ViewEmployeeAtt_Arrayadapter(data, ViewEmployeeAtt_data.this);
                            recyclerView.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<List<ViewEmployeeAttData_model>> call, Throwable t) {

                            Toast.makeText(ViewEmployeeAtt_data.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

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
                        ViewEmployeeAtt_data.this,
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
                        ViewEmployeeAtt_data.this,
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
