package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts.Viewemployee_Annual_LeaveCharts;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.Viewemployee_Monthly_LeaveCharts;

public class Viewemployee_charts extends AppCompatActivity implements View.OnClickListener{

    private CardView employeeleaveannualcard, employeeleavemonthlycard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewemployee_charts);

        employeeleaveannualcard = (CardView) findViewById(R.id.AnnualEMP_LeaveCharts);
        employeeleavemonthlycard = (CardView) findViewById(R.id.MonthlyEMP_LeaveCharts);

        employeeleaveannualcard.setOnClickListener(this);
        employeeleavemonthlycard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.AnnualEMP_LeaveCharts : i = new Intent(this, Viewemployee_Annual_LeaveCharts.class);startActivity(i); break;
            case  R.id.MonthlyEMP_LeaveCharts : i = new Intent(this, Viewemployee_Monthly_LeaveCharts.class);startActivity(i); break;
            default:break;
        }

    }
}
