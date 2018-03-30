package projectv2.technocoders.com.finalproject.home.leave.applyleave.api;

import projectv2.technocoders.com.finalproject.home.leave.applyleave.models.UserLeave;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServiceleave {

        @FormUrlEncoded
        @POST("api/Leaves")
        Call<UserLeave> createUser(
                @Field("EID") String eid,
                @Field("date") String date,
                @Field("leaveCategory") String leavecategory,
                @Field("reason") String reason);

    }

