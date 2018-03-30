package projectv2.technocoders.com.finalproject.home.leave.leavecharts.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home.leave.leavecharts.model.Individual_leave_charts_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 2/1/2018.
 */

public interface APIService_IndividualLeave_charts {

    @GET("api/Leaves/LeaveCount")
    Call<List<Individual_leave_charts_model>> getIndividualleavecharts(@Query("EID") String EID);
}
