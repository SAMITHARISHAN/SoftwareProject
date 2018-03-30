package projectv2.technocoders.com.finalproject.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import projectv2.technocoders.com.finalproject.LocalStore;
import projectv2.technocoders.com.finalproject.NotificationService;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.attendance.Attendance;
import projectv2.technocoders.com.finalproject.home.leave.Leave;
import projectv2.technocoders.com.finalproject.home.notification.Notification;
import projectv2.technocoders.com.finalproject.home.schedule.Schedule;
import projectv2.technocoders.com.finalproject.login.Login;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    GridLayout mainGrid;
    LocalStore localStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        localStore = new LocalStore(getApplicationContext());

        Intent intent = new Intent(MainActivity.this, NotificationService.class);
        startService(intent);


        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        mDrawerlayout =(DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerlayout,R.string.open,R.string.close );
//        mDrawerlayout.addDrawerListener(mToggle);
//        mToggle.syncState();
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
                        Intent intent  = new Intent(MainActivity.this, Attendance.class);
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
                        Intent intent  = new Intent(MainActivity.this, Leave.class);
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
                        Intent intent  = new Intent(MainActivity.this, Schedule.class);
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
                        Intent intent  = new Intent(MainActivity.this, Notification.class);
                        startActivity(intent);
                    }
                });
            }

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {
            localStore.setUserLoggedIn(false);
            startActivity(new Intent(MainActivity.this,Login.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
