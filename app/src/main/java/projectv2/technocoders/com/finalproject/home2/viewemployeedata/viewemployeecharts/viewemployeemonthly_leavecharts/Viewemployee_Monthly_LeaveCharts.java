package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.api.APIService_viewEMPmonthly_charts;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.model.ViewEMP_monthlycharts_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Viewemployee_Monthly_LeaveCharts extends AppCompatActivity {


    Float monday,tuesday,wednesday,thursday,friday,saturday,sunday;

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewemployee__monthly__leave_charts);

        pieChart = (PieChart)findViewById(R.id.viewmonthlyleavepiechart);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrlLeavetaken.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService_viewEMPmonthly_charts service = retrofit.create(APIService_viewEMPmonthly_charts.class);

        Call<ViewEMP_monthlycharts_model> call = service.getmonthlyleavechartdata();

            call.enqueue(new Callback<ViewEMP_monthlycharts_model>() {
                @Override
                public void onResponse(Call<ViewEMP_monthlycharts_model> call, Response<ViewEMP_monthlycharts_model> response) {

                    ViewEMP_monthlycharts_model viewempmonthlychart_model= response.body();
                    monday = Float.parseFloat(viewempmonthlychart_model.getMonday());
                    tuesday = Float.parseFloat(viewempmonthlychart_model.getTuesday());
                    wednesday = Float.parseFloat(viewempmonthlychart_model.getWednesday());
                    thursday = Float.parseFloat(viewempmonthlychart_model.getThursday());
                    friday = Float.parseFloat(viewempmonthlychart_model.getFriday());
                    saturday = Float.parseFloat(viewempmonthlychart_model.getSaturday());
                    sunday = Float.parseFloat(viewempmonthlychart_model.getSunday());

                    pieChart.setUsePercentValues(true);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setExtraOffsets(5, 10, 5, 5);

                    pieChart.setDragDecelerationFrictionCoef(0.95f);

                    pieChart.setDrawHoleEnabled(true);
                    pieChart.setHoleColor(Color.WHITE);
                    pieChart.setTransparentCircleRadius(61f);

                    ArrayList<PieEntry> yValues = new ArrayList<>();

                    yValues.add(new PieEntry(monday, "Monday"));
                    yValues.add(new PieEntry(tuesday, "Tuesday"));
                    yValues.add(new PieEntry(wednesday, "Wednesday"));
                    yValues.add(new PieEntry(thursday, "Thursday"));
                    yValues.add(new PieEntry(friday, "Friday"));
                    yValues.add(new PieEntry(saturday, "Saturday"));
                    yValues.add(new PieEntry(sunday, "Sunday"));

                    PieDataSet dataSet = new PieDataSet(yValues, "Avg leaves");
                    dataSet.setSliceSpace(3f);
                    dataSet.setSelectionShift(5f);
                    dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                    PieData data = new PieData((dataSet));
                    data.setValueTextSize(25f);
                    data.setValueTextColor(Color.WHITE);

                    pieChart.setData(data);
                    Toast.makeText(Viewemployee_Monthly_LeaveCharts.this,"Sending Successful",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ViewEMP_monthlycharts_model> call, Throwable t) {

                    Toast.makeText(Viewemployee_Monthly_LeaveCharts.this,"Sending Fail",Toast.LENGTH_SHORT).show();
                }
            });
    }
}
