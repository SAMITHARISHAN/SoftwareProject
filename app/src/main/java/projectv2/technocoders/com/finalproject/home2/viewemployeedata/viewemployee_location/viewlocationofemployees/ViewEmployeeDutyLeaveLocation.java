package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.api.APIService_LocationTracking;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.model.EmployeeLocationTracking_model;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.viewlocationArrayadapter.EmployeeLocationArrayadapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewEmployeeDutyLeaveLocation extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<EmployeeLocationTracking_model> data;
    private EmployeeLocationArrayadapter adapter;
    public static String Location;
    public static String B_Time;
    public static String E_Time;
    private String DLID;
    private Button buttonlocationtracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee_duty_leave_location);

        buttonlocationtracking = (Button)findViewById(R.id.buttonchecklocation);

        Bundle bundle = getIntent().getExtras();
        DLID = bundle.getString("dlid");
        Location = bundle.getString("location");
        B_Time = bundle.getString("b_time");
        E_Time = bundle.getString("e_time");


        buttonlocationtracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView = (RecyclerView) findViewById(R.id.item_listtracklocation);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlLeavetaken.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService_LocationTracking service = retrofit.create(APIService_LocationTracking.class);

                retrofit2.Call<List<EmployeeLocationTracking_model>> call = service.getdlid(DLID);

                call.enqueue(new Callback<List<EmployeeLocationTracking_model>>() {
                    @Override
                    public void onResponse(Call<List<EmployeeLocationTracking_model>> call, Response<List<EmployeeLocationTracking_model>> response) {


                        Toast.makeText(ViewEmployeeDutyLeaveLocation.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                        data = (ArrayList<EmployeeLocationTracking_model>)response.body();
                        adapter = new EmployeeLocationArrayadapter(data, ViewEmployeeDutyLeaveLocation.this);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<List<EmployeeLocationTracking_model>> call, Throwable t) {

                        Toast.makeText(ViewEmployeeDutyLeaveLocation.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

                    }
                });


            }
        });


    }
}
