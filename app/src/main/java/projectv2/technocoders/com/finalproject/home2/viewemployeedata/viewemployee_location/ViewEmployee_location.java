package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location;

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
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.api.APIService_Dutyleave_data;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.locationdutyleavearrayadapter.Location_Dutyleave_ArrayAdapter;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.model.DutyLeaveData_model;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewEmployee_location extends AppCompatActivity {


    RecyclerView recyclerView;
    private ArrayList<DutyLeaveData_model> data;
    private Location_Dutyleave_ArrayAdapter adapter;
    private static final String TAG = "viewemployeelcation";
    private Button buttonstartdate;
    private Button buttonenddate;
    private Button buttonsendalocation;
    Login eidlocationdata;
    String begintime;
    String endtime;
    public  static String DLIDemployee;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;
    private DatePickerDialog.OnDateSetListener mDateSetListner2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee_location);


        buttonstartdate = (Button) findViewById(R.id.begintimelocationdetails);
        buttonenddate = (Button) findViewById(R.id.endtimelocationdetails);


        begintimeattData();
        endtimeattData();

        buttonsendalocation = (Button)findViewById(R.id.buttonsendlocationdetails);

        buttonsendalocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(begintime == null || endtime == null)
                {
                    Toast.makeText(ViewEmployee_location.this,"Please select start date and end date",Toast.LENGTH_LONG).show();
                }else {


                    String eid  = eidlocationdata.EIDemployee;

                    recyclerView = (RecyclerView) findViewById(R.id.item_list_locatoindetails);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(APIUrlLeavetaken.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIService_Dutyleave_data service = retrofit.create(APIService_Dutyleave_data.class);

                    retrofit2.Call<List<DutyLeaveData_model>> call = service.getDutyLeaveData(eid,begintime,endtime);

                    call.enqueue(new Callback<List<DutyLeaveData_model>>() {
                        @Override
                        public void onResponse(Call<List<DutyLeaveData_model>> call, Response<List<DutyLeaveData_model>> response) {

                            Toast.makeText(ViewEmployee_location.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();

                            data = (ArrayList<DutyLeaveData_model>)response.body();
                            adapter = new Location_Dutyleave_ArrayAdapter(data, ViewEmployee_location.this);
                            recyclerView.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<List<DutyLeaveData_model>> call, Throwable t) {

                            Toast.makeText(ViewEmployee_location.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

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
                        ViewEmployee_location.this,
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
                        ViewEmployee_location.this,
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
