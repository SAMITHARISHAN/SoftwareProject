package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.model.ViewEmployeeLeave_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus PC on 1/28/2018.
 */

public interface APIService_viewemployee_leaveData {

    @GET("api/Leaves/GetManaged/")
    Call<List<ViewEmployeeLeave_model>> getviewemployeeleavedata(@Query("ManagerID") String ManagerID);

}
