package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.api;


import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.model.LeaveAcceptReject_model;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService_leave_acceptreject {

    @FormUrlEncoded
    @PUT("api/Approvals/{id}")
    Call<LeaveAcceptReject_model> getleaveacceptreject(@Path("id") String APID,
                                                       @Field("status") String status);

    

}
