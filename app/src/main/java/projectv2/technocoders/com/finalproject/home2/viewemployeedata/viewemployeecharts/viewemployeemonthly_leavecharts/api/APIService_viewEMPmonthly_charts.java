package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.api;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.model.ViewEMP_monthlycharts_model;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Asus PC on 1/31/2018.
 */

public interface APIService_viewEMPmonthly_charts {

    @GET("api/Leaves/LeavesAppliedWeekly")
    Call<ViewEMP_monthlycharts_model> getmonthlyleavechartdata();
}
