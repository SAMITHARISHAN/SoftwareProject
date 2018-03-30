package projectv2.technocoders.com.finalproject.home.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.attendance.attendancecharts.AttendanceCharts;
import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.AttendanceDetails;

public class Attendance extends AppCompatActivity implements View.OnClickListener{
    private CardView attendancedetailscard,attendancechartscard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        attendancedetailscard = (CardView) findViewById(R.id.attendancereport_card);
        attendancechartscard = (CardView)findViewById(R.id.attendancechart_card);



        attendancedetailscard.setOnClickListener(this);
        attendancechartscard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.attendancereport_card : i = new Intent(this, AttendanceDetails.class);startActivity(i); break;
            case  R.id.attendancechart_card : i = new Intent(this, AttendanceCharts.class);startActivity(i); break;
          //  case  R.id.attendancestats_card : i = new Intent(this, AttendanceStats.class);startActivity(i); break;
            default:break;
        }

    }
}
