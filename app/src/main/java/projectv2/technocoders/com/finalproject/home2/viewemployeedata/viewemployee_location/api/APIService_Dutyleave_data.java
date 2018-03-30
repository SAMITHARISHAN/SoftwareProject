package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.model.DutyLeaveData_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 1/25/2018.
 */

public interface APIService_Dutyleave_data {


    @GET("api/DutyLeaves/GetManaged")
    Call<List<DutyLeaveData_model>> getDutyLeaveData(@Query("EID") String EID, @Query("startDate") String startdate, @Query("endDate") String enddate);


}
