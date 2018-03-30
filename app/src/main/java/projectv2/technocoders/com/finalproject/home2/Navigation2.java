package projectv2.technocoders.com.finalproject.home2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import projectv2.technocoders.com.finalproject.LocalStore;
import projectv2.technocoders.com.finalproject.NotificationService;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.Navigation1;
import projectv2.technocoders.com.finalproject.home.attendance.Attendance;
import projectv2.technocoders.com.finalproject.home.leave.Leave;
import projectv2.technocoders.com.finalproject.home.notification.Notification;
import projectv2.technocoders.com.finalproject.home.schedule.Schedule;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.HandlingEMP_LeaveRequests;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.ViewEmployeeData;
import projectv2.technocoders.com.finalproject.login.Login;

public class Navigation2 extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    GridLayout mainGrid;
    LocalStore localStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation2);

        localStore = new LocalStore(getApplicationContext());

        Intent intent = new Intent(Navigation2.this, NotificationService.class);
        startService(intent);


        mainGrid = (GridLayout)findViewById(R.id.mainGrid2);
        mDrawerlayout =(DrawerLayout) findViewById(R.id.drawer2);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close );
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i = 0; i < mainGrid.getChildCount(); i++)
        {
            final CardView cardview = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            if(finalI == 0)
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, Attendance.class);
                        startActivity(intent);
                    }
                });
            }

            else if(finalI == 1)
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, Leave.class);
                        startActivity(intent);
                    }
                });
            }

            else if(finalI == 2)
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, Schedule.class);
                        startActivity(intent);
                    }
                });
            }

            else if(finalI == 3)
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, Notification.class);
                        startActivity(intent);
                    }
                });
            }

            else if(finalI == 4)
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, ViewEmployeeData.class);
                        startActivity(intent);
                    }
                });
            }

               else
            {
                cardview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cardview.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Intent intent  = new Intent(projectv2.technocoders.com.finalproject.home2.Navigation2.this, HandlingEMP_LeaveRequests.class);
                        startActivity(intent);
                    }
                });
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.setting) {
            localStore.setUserLoggedIn(false);
            localStore.clearUser();
            Intent intent=new Intent(this,Login.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
