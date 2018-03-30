package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts.api;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeeannual_leavecharts.model.ViewEMP_annualleavecharts_model;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Asus PC on 1/31/2018.
 */

public interface APIService_viewemployee_annualleavecharts {

    @GET("api/Leaves/LeavesAppliedMonthly")
    Call<ViewEMP_annualleavecharts_model> getannualleavechartdata();

}
