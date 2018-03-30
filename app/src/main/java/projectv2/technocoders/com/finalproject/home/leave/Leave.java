package projectv2.technocoders.com.finalproject.home.leave;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.applydutyleave.ApplydutyLeave;
import projectv2.technocoders.com.finalproject.home.leave.applyleave.ApplyLeave;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.Leavecharts;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.LeaveDetails;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home.leave.locationtracking.APIService_trackLocation;
import projectv2.technocoders.com.finalproject.home.leave.locationtracking.model.LocationTracking_model;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Leave extends AppCompatActivity implements View.OnClickListener {
    private CardView leavedetailscard, applyleavecard, dutyleavecard, leavechartscard;
    private Button buttontrackmylocation;

    public static double lat;
    public static double log;

    Login eidtracklocation;
    LocationManager locationManager;
    final int REQUEST_LOCATION = 1;
    LocationListener locationListner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        leavedetailscard = (CardView) findViewById(R.id.leavedetails_card);
        applyleavecard = (CardView) findViewById(R.id.applyleave_card);
        dutyleavecard = (CardView) findViewById(R.id.applydutyleave_card);
        leavechartscard = (CardView) findViewById(R.id.leavecharts_card);
        buttontrackmylocation = (Button) findViewById(R.id.btntracklocation);

        leavedetailscard.setOnClickListener(this);
        applyleavecard.setOnClickListener(this);
        dutyleavecard.setOnClickListener(this);
        leavechartscard.setOnClickListener(this);
        buttontrackmylocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.leavedetails_card:
                i = new Intent(this, LeaveDetails.class);
                startActivity(i);
                break;
            case R.id.applyleave_card:
                i = new Intent(this, ApplyLeave.class);
                startActivity(i);
                break;
            case R.id.applydutyleave_card:
                i = new Intent(this, ApplydutyLeave.class);
                startActivity(i);
                break;
            case R.id.leavecharts_card:
                i = new Intent(this, Leavecharts.class);
                startActivity(i);
                break;
            case R.id.btntracklocation:trackmylocation();
                break;
            default:
                break;
        }

    }

    private void trackmylocation() {

        Toast.makeText(Leave.this, "trackmylocation method", Toast.LENGTH_SHORT).show();



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListner = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                lat = location.getLatitude();
                log = location.getLongitude();

                sendlocation();
                Toast.makeText(Leave.this, "send location method",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);
            }
            return;
        } else {

            locationManager.requestLocationUpdates("gps", 10000, 0, locationListner);
        }
    }

   public void configureButton() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        else{
            locationManager.requestLocationUpdates("gps", 10000, 0, locationListner);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 10:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();

        }
    }

    private void sendlocation() {

     // Toast.makeText(Leave.this, "send location method",Toast.LENGTH_SHORT).show();

        String longitude = Double.toString(log);
        String latitude = Double.toString(lat);
        String eid = eidtracklocation.EIDemployee;


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrlLeavetaken.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService_trackLocation service = retrofit.create(APIService_trackLocation.class);

        LocationTracking_model user = new LocationTracking_model(eid,longitude,latitude);

        Call<LocationTracking_model> call = service.createUser(

                user.getEID(),
                user.getLongitude(),
                user.getLatitude()

        );

        call.enqueue(new Callback<LocationTracking_model>(){

            @Override
            public void onResponse(Call<LocationTracking_model> call, Response<LocationTracking_model> response) {

                Toast.makeText(Leave.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LocationTracking_model> call, Throwable t) {

                Toast.makeText(Leave.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
            }
        });

    }
}

