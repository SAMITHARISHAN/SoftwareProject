package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.api;


import java.util.List;

import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.model.Handling_leaverequest_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService_handling_leaverequest {

    @GET("api/Approvals")
    Call<List<Handling_leaverequest_model>> getleaverequest(@Query("ManagerID") String managerID, @Query("status") String status);


}
