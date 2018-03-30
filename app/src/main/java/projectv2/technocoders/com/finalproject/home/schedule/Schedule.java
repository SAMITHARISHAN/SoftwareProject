package projectv2.technocoders.com.finalproject.home.schedule;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.schedule.shedulerecyclerview.ScheduleList;

public class Schedule extends AppCompatActivity {

    final int LIST_REQUEST = 1;
    final int LIST_RESULT = 100;
    ArrayList<String> list;
    private CardView buttonaddschedule, buttonviewcalender;
    int year_x, month_x,day_x;
    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

       Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();
        AddNewSchedule();

    }

    public  void showDialogOnButtonClick(){
        buttonviewcalender = (CardView) findViewById(R.id.viewcalender_card);

        buttonviewcalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              showDialog(DIALOG_ID);

            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x, month_x,day_x);
           return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                    year_x = year;
                    month_x = month + 1;
                    day_x = day;

                    Toast.makeText(Schedule.this, year_x + "/" + month_x + "/" + day_x,Toast.LENGTH_LONG).show();
                }
            };


            public void AddNewSchedule(){

                buttonaddschedule = (CardView) findViewById(R.id.addschedule_card);
                   buttonaddschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Schedule.this, ScheduleList.class);
                if(list == null) {
                    list = new ArrayList<>();
                }
                i.putStringArrayListExtra("list", list);
                startActivityForResult(i, LIST_REQUEST);

            }
        });

            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == LIST_REQUEST && resultCode == LIST_RESULT)
            list = data.getStringArrayListExtra("list");
    }


}
