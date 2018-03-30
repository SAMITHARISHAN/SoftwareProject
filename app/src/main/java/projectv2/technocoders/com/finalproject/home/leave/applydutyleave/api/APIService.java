package projectv2.technocoders.com.finalproject.home.leave.applydutyleave.api;

import projectv2.technocoders.com.finalproject.home.leave.applydutyleave.models.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("dutyleaves")
    Call<User> createUser(
            @Field("EID") String eid,
            @Field("date") String date,
            @Field("location") String location,
            @Field("appointmentTime") String appointmentTime,
            @Field("endTime") String duration,
            @Field("purpose") String purpose);


    //Callback<Response> callback);
}
