package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.model.EmployeeLocationTracking_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 1/26/2018.
 */

public interface APIService_LocationTracking {


    @GET("api/Trackings")
    Call<List<EmployeeLocationTracking_model>> getdlid(@Query("DLID") String DLID);
}
