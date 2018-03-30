package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts;

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
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts.api.APIService_viewemployee_annualleavecharts;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts.model.ViewEMP_annualleavecharts_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Viewemployee_Annual_LeaveCharts extends AppCompatActivity {

    float january,february,march,april,may,june,july,august,september,october,november,december;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewemployee__annual__leave_charts);

        pieChart = (PieChart)findViewById(R.id.viewannualleavepiechart);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrlLeavetaken.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService_viewemployee_annualleavecharts service = retrofit.create(APIService_viewemployee_annualleavecharts.class);

        Call<ViewEMP_annualleavecharts_model> call = service.getannualleavechartdata();

        call.enqueue(new Callback<ViewEMP_annualleavecharts_model>() {
            @Override
            public void onResponse(Call<ViewEMP_annualleavecharts_model> call, Response<ViewEMP_annualleavecharts_model> response) {

                ViewEMP_annualleavecharts_model viewemp_annualleavechart_model = response.body();
                january = Float.parseFloat(viewemp_annualleavechart_model.getJanuary());
                february = Float.parseFloat(viewemp_annualleavechart_model.getFebruary());
                march = Float.parseFloat(viewemp_annualleavechart_model.getMarch());
                april = Float.parseFloat(viewemp_annualleavechart_model.getApril());
                may = Float.parseFloat(viewemp_annualleavechart_model.getMay());
                june = Float.parseFloat(viewemp_annualleavechart_model.getJune());
                july = Float.parseFloat(viewemp_annualleavechart_model.getJuly());
                august = Float.parseFloat(viewemp_annualleavechart_model.getAugust());
                september = Float.parseFloat(viewemp_annualleavechart_model.getSeptember());
                october = Float.parseFloat(viewemp_annualleavechart_model.getOctober());
                november = Float.parseFloat(viewemp_annualleavechart_model.getNovember());
                december = Float.parseFloat(viewemp_annualleavechart_model.getDecember());


                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5, 10, 5, 5);

                pieChart.setDragDecelerationFrictionCoef(0.95f);

                pieChart.setDrawHoleEnabled(true);
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setTransparentCircleRadius(61f);

                ArrayList<PieEntry> yValues = new ArrayList<>();


                 if(january > 0){
                     yValues.add(new PieEntry(january, "January"));
                 }

                if(february > 0){
                    yValues.add(new PieEntry(february, "February"));
                }
                if(march > 0){
                    yValues.add(new PieEntry(march, "March"));
                }
                if(april > 0){
                    yValues.add(new PieEntry(april, "April"));
                }
                if(may > 0){
                    yValues.add(new PieEntry(may, "May"));
                }
                if(june > 0){
                    yValues.add(new PieEntry(june, "June"));
                }
                if(july > 0){
                    yValues.add(new PieEntry(july, "July"));
                }
                if(august > 0){
                    yValues.add(new PieEntry(august, "August"));
                }
                if(september > 0){
                    yValues.add(new PieEntry(september, "September"));
                }
                if(october > 0){
                    yValues.add(new PieEntry(october, "October"));
                }
                if(november > 0){
                    yValues.add(new PieEntry(november, "November"));
                }
                if(december > 0){
                    yValues.add(new PieEntry(december, "December"));
                }

                PieDataSet dataSet = new PieDataSet(yValues, "Avg leaves");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                PieData data = new PieData((dataSet));
                data.setValueTextSize(20f);
                data.setValueTextColor(Color.WHITE);

                pieChart.setData(data);
                Toast.makeText(Viewemployee_Annual_LeaveCharts.this,"Sending Successful",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ViewEMP_annualleavecharts_model> call, Throwable t) {

                Toast.makeText(Viewemployee_Annual_LeaveCharts.this,"Sending Fail",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
