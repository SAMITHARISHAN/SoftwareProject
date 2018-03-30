package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests;

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
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.api.APIService_handling_leaverequest;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.handling_leaverequest_arrayadapter.Handling_leaverequest_arrayadapter;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.model.Handling_leaverequest_model;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HandlingEMP_LeaveRequests extends AppCompatActivity {


    RecyclerView recyclerView;
    private ArrayList<Handling_leaverequest_model> data;
    private Handling_leaverequest_arrayadapter adapter;
    Login eidhandlingleaverequest;
    Button viewpendingleaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handling_emp__leave_requests);

   viewpendingleaves = (Button)findViewById(R.id.buttoncheckleaverequest);

        viewpendingleaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eid  = eidhandlingleaverequest.EIDemployee;
                String status = "pending";

                recyclerView = (RecyclerView) findViewById(R.id.item_list_handlingleaverequest);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlLeavetaken.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                APIService_handling_leaverequest service = retrofit.create(APIService_handling_leaverequest.class);

                Call<List<Handling_leaverequest_model>> call = service.getleaverequest(eid,status);

                call.enqueue(new Callback<List<Handling_leaverequest_model>>() {
                    @Override
                    public void onResponse(Call<List<Handling_leaverequest_model>> call, Response<List<Handling_leaverequest_model>> response) {

                        Toast.makeText(HandlingEMP_LeaveRequests.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                        data = (ArrayList<Handling_leaverequest_model>)response.body();
                        adapter = new Handling_leaverequest_arrayadapter(data, HandlingEMP_LeaveRequests.this);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override

                    public void onFailure(Call<List<Handling_leaverequest_model>> call, Throwable t) {

                        Toast.makeText(HandlingEMP_LeaveRequests.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


    }
}
