package projectv2.technocoders.com.finalproject.home.leave.locationtracking;

import projectv2.technocoders.com.finalproject.home.leave.locationtracking.model.LocationTracking_model;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Asus PC on 1/24/2018.
 */

public interface APIService_trackLocation {

    @FormUrlEncoded
    @POST("api/Trackings")
    Call<LocationTracking_model> createUser(
            @Field("EID") String eid,
            @Field("longitude") String longitude,
            @Field("latitude") String latitude);

}
