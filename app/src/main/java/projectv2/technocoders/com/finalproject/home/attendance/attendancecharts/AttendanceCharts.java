package projectv2.technocoders.com.finalproject.home.attendance.attendancecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.attendance.attendancecharts.annual.AnnualattendanceCharts;
import projectv2.technocoders.com.finalproject.home.attendance.attendancecharts.monthly.MonthlyattendanceCharts;

public class AttendanceCharts extends AppCompatActivity implements View.OnClickListener {

    private CardView attendanceannualcard, attendancemonthlycard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_charts);

        attendanceannualcard = (CardView) findViewById(R.id.AnnualAttendanceCharts);
        attendancemonthlycard = (CardView)findViewById(R.id.MonthlyAttendanceCharts);



        attendanceannualcard.setOnClickListener(this);
        attendancemonthlycard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.AnnualAttendanceCharts : i = new Intent(this, AnnualattendanceCharts.class);startActivity(i); break;
            case  R.id.MonthlyAttendanceCharts : i = new Intent(this, MonthlyattendanceCharts.class);startActivity(i); break;
            default:break;
        }
    }
}
