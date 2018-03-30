package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.api;

import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.model.EditandDeleteLeave_model;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService_EditandDelete_leaves {

    @FormUrlEncoded
    @PUT("api/Leaves/{id}")
    Call<EditandDeleteLeave_model> createUser(@Path("id") String id,
            @Field("date") String date,
            @Field("leaveCategory") String leavecategory,
            @Field("reason") String reason);
}
