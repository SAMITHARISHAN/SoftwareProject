package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data;

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
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.api.APIService_viewemployee_leaveData;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.model.ViewEmployeeLeave_model;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.viewemployeeleavedataArrayadapter.ViewEMPleave_Data_Arrayadapter;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewEmployeeleave_data extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<ViewEmployeeLeave_model> data;
    private ViewEMPleave_Data_Arrayadapter adapter;
    private Button buttonviewempLeaveData;
    Login eidviewEMPleavedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employeeleave_data);

        buttonviewempLeaveData  = (Button)findViewById(R.id.buttonsendviewleavedata) ;

        buttonviewempLeaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eid  = eidviewEMPleavedata.EIDemployee;

                recyclerView = (RecyclerView) findViewById(R.id.item_list_viewemployeeleavedata);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

                OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlLeavetaken.BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService_viewemployee_leaveData service = retrofit.create(APIService_viewemployee_leaveData.class);

                retrofit2.Call<List<ViewEmployeeLeave_model>> call = service.getviewemployeeleavedata(eid);

                call.enqueue(new Callback<List<ViewEmployeeLeave_model>>() {
                    @Override
                    public void onResponse(Call<List<ViewEmployeeLeave_model>> call, Response<List<ViewEmployeeLeave_model>> response) {

                        Toast.makeText(ViewEmployeeleave_data.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                        data = (ArrayList<ViewEmployeeLeave_model>)response.body();
                        adapter = new ViewEMPleave_Data_Arrayadapter(data, ViewEmployeeleave_data.this);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<List<ViewEmployeeLeave_model>> call, Throwable t) {

                        Toast.makeText(ViewEmployeeleave_data.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
