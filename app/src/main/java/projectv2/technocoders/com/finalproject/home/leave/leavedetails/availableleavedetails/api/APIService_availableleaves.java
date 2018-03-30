package projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.model.Available_leave_data_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 1/25/2018.
 */

public interface APIService_availableleaves {

    @GET("api/Leaves/GetAvailable/")
    Call<List<Available_leave_data_model>> getavailableleaves(@Query("EID") String EID);

}
