package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.model.UserLeaveTaken;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 1/22/2018.
 */

public interface APIServiceleavetaken {

    @GET("api/Leaves")
    Call<List<UserLeaveTaken>> gettakenleave(@Query("EID") String EID, @Query("startDate") String startdate, @Query("endDate") String enddate);

}
