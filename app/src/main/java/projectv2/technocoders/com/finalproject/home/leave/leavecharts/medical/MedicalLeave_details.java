package projectv2.technocoders.com.finalproject.home.leave.leavecharts.medical;

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
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.api.APIService_IndividualLeave_charts;
import projectv2.technocoders.com.finalproject.home.leave.leavecharts.model.Individual_leave_charts_model;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.login.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MedicalLeave_details extends AppCompatActivity {

    PieChart pieChart;
    private ArrayList<Individual_leave_charts_model> data;
    Login eidmedicalLeavecharts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_leave_details);

        pieChart = (PieChart)findViewById(R.id.medicalleavepiechart);
        String eid = eidmedicalLeavecharts.EIDemployee;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrlLeavetaken.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService_IndividualLeave_charts service = retrofit.create(APIService_IndividualLeave_charts.class);

        Call<List<Individual_leave_charts_model>>  call = service.getIndividualleavecharts(eid);

        call.enqueue(new Callback<List<Individual_leave_charts_model>>() {
            @Override
            public void onResponse(Call<List<Individual_leave_charts_model>> call, Response<List<Individual_leave_charts_model>> response) {

                data = (ArrayList<Individual_leave_charts_model>)response.body();
                float leavetaken = Float.parseFloat(data.get(2).getTakencount());
                float leaveleft = Float.parseFloat(data.get(2).getLeftcount());
                Toast.makeText(MedicalLeave_details.this,"Sending Success",Toast.LENGTH_SHORT).show();

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5, 10, 5, 5);

                pieChart.setDragDecelerationFrictionCoef(0.95f);

                pieChart.setDrawHoleEnabled(true);
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setTransparentCircleRadius(61f);

                ArrayList<PieEntry> yValues = new ArrayList<>();

                yValues.add(new PieEntry(leavetaken, "taken"));
                yValues.add(new PieEntry(leaveleft, "left"));

                PieDataSet dataSet = new PieDataSet(yValues, "Medical Leaves");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                PieData data = new PieData((dataSet));
                data.setValueTextSize(25f);
                data.setValueTextColor(Color.WHITE);

                pieChart.setData(data);
                Toast.makeText(MedicalLeave_details.this,"Sending Successful",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Individual_leave_charts_model>> call, Throwable t) {

                Toast.makeText(MedicalLeave_details.this,"Sending Fail"+t,Toast.LENGTH_LONG).show();
            }
        });


    }
    }
