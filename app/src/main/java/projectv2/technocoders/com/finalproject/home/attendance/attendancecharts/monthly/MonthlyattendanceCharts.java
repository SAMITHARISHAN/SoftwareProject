package projectv2.technocoders.com.finalproject.home.attendance.attendancecharts.monthly;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import projectv2.technocoders.com.finalproject.R;

public class MonthlyattendanceCharts extends AppCompatActivity {

       float x = 85f;
       float y = 15f;
        PieChart pieChart;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_monthlyattendance_charts);

            pieChart = (PieChart)findViewById(R.id.attendancemonthlypiechart);

            pieChart.setUsePercentValues(true);
            pieChart.getDescription().setEnabled(false);
            pieChart.setExtraOffsets(5, 10, 5, 5);

            pieChart.setDragDecelerationFrictionCoef(0.95f);

            pieChart.setDrawHoleEnabled(true);
            pieChart.setHoleColor(Color.WHITE);
            pieChart.setTransparentCircleRadius(61f);

            ArrayList<PieEntry> yValues = new ArrayList<>();

            yValues.add(new PieEntry(x, "Present"));
            yValues.add(new PieEntry(y, "Absent"));

            PieDataSet dataSet = new PieDataSet(yValues, "Attendance");
            dataSet.setSliceSpace(3f);
            dataSet.setSelectionShift(5f);
            dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

            PieData data = new PieData((dataSet));
            data.setValueTextSize(25f);
            data.setValueTextColor(Color.YELLOW);

            pieChart.setData(data);

        }
    }
