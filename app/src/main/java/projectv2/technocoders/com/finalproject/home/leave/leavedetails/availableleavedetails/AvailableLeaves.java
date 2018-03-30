package projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails;

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
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.api.APIService_availableleaves;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.leaveavailablearrayadapter.Available_leave_ArrayAdapter;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.model.Available_leave_data_model;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AvailableLeaves extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Available_leave_data_model> data;
    private Available_leave_ArrayAdapter adapter;
    private static final String TAG = "AttendanceDetails";
    private Button buttonsendavailableleave;
    Login eidavailableleaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_leaves);

        buttonsendavailableleave  = (Button)findViewById(R.id.buttonsendavailableleaves) ;

          buttonsendavailableleave.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  String eid  = eidavailableleaves.EIDemployee;


                  recyclerView = (RecyclerView) findViewById(R.id.item_listavailableleaves);
                  recyclerView.setHasFixedSize(true);
                  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                  recyclerView.setLayoutManager(layoutManager);
                  recyclerView.setItemAnimator(new DefaultItemAnimator());


                  Retrofit retrofit = new Retrofit.Builder()
                          .baseUrl(APIUrlLeavetaken.BASE_URL)
                          .addConverterFactory(GsonConverterFactory.create())
                          .build();

                  APIService_availableleaves service = retrofit.create(APIService_availableleaves.class);

                  Call<List<Available_leave_data_model>> call = service.getavailableleaves(eid);

                  call.enqueue(new Callback<List<Available_leave_data_model>>() {
                      @Override
                      public void onResponse(Call<List<Available_leave_data_model>> call, Response<List<Available_leave_data_model>> response) {

                          Toast.makeText(AvailableLeaves.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                          data = (ArrayList<Available_leave_data_model>)response.body();
                          adapter = new Available_leave_ArrayAdapter(data, AvailableLeaves.this);
                          recyclerView.setAdapter(adapter);
                      }

                      @Override
                      public void onFailure(Call<List<Available_leave_data_model>> call, Throwable t) {

                          Toast.makeText(AvailableLeaves.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
                      }
                  });

              }
          });
    }

}
