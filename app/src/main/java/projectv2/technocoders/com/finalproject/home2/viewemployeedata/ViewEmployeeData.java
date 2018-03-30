package projectv2.technocoders.com.finalproject.home2.viewemployeedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.ViewEmployee_location;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.ViewEmployeeAtt_data;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.Viewemployee_charts;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.ViewEmployeeleave_data;

public class ViewEmployeeData extends AppCompatActivity implements View.OnClickListener{
    private CardView em_attdatacard,em_leavedatacard,em_locationcard,em_leavechartcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee_data);

        em_attdatacard = (CardView)findViewById(R.id.employeeattdata_card);
        em_leavedatacard = (CardView)findViewById(R.id.employeealeavedata_card);
        em_locationcard = (CardView)findViewById(R.id.employeelocationdata_card);
        em_leavechartcard = (CardView)findViewById(R.id.employeeleavechart_card);

        em_attdatacard.setOnClickListener(this);
        em_leavedatacard.setOnClickListener(this);
        em_locationcard.setOnClickListener(this);
        em_leavechartcard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        Intent i;

        switch (view.getId()){
            case R.id.employeeattdata_card : i = new Intent(this, ViewEmployeeAtt_data.class);startActivity(i); break;
            case  R.id.employeealeavedata_card : i = new Intent(this, ViewEmployeeleave_data.class);startActivity(i); break;
            case  R.id.employeelocationdata_card : i = new Intent(this, ViewEmployee_location.class);startActivity(i); break;
            case  R.id.employeeleavechart_card : i = new Intent(this, Viewemployee_charts.class);startActivity(i); break;
            default:break;
        }

    }
}
