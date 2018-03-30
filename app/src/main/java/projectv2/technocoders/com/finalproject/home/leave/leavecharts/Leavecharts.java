package projectv2.technocoders.com.finalproject.home.leave.leavecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.casual.CasualLeave_details;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.half_day.HalfDay_details;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.medical.MedicalLeave_details;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.short_leave.ShortLeave_details;

public class Leavecharts extends AppCompatActivity implements View.OnClickListener {

    private CardView casualleavecard, medicalleavecard,shortleaveleavecard,halfdaycard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leavecharts);

        casualleavecard = (CardView) findViewById(R.id.casualLeaveCharts);
        medicalleavecard = (CardView)findViewById(R.id.medicalLeaveCharts);
        shortleaveleavecard = (CardView)findViewById(R.id.shortLeaveCharts);
        halfdaycard = (CardView)findViewById(R.id.HalfdayCharts);



        casualleavecard.setOnClickListener(this);
        medicalleavecard.setOnClickListener(this);
        shortleaveleavecard.setOnClickListener(this);
        halfdaycard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.casualLeaveCharts : i = new Intent(this, CasualLeave_details.class);startActivity(i); break;
            case  R.id.medicalLeaveCharts : i = new Intent(this, MedicalLeave_details.class);startActivity(i); break;
            case  R.id.shortLeaveCharts : i = new Intent(this, ShortLeave_details.class);startActivity(i); break;
            case  R.id.HalfdayCharts : i = new Intent(this, HalfDay_details.class);startActivity(i); break;
            default:break;
        }
    }
}
