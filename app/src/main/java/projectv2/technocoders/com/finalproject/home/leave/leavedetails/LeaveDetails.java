package projectv2.technocoders.com.finalproject.home.leave.leavedetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.AvailableLeaves;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.LeaveTakenDetails;

public class LeaveDetails extends AppCompatActivity implements View.OnClickListener {

    private CardView leavetakendetails,availableleaves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_details);

        leavetakendetails = (CardView) findViewById(R.id.leavetakendetails_card);
        availableleaves = (CardView)findViewById(R.id.remainingleaves_card);


        leavetakendetails.setOnClickListener(this);
        availableleaves.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.leavetakendetails_card : i = new Intent(this, LeaveTakenDetails.class);startActivity(i); break;
            case  R.id.remainingleaves_card : i = new Intent(this, AvailableLeaves.class);startActivity(i); break;
            default:break;
        }
    }
}
