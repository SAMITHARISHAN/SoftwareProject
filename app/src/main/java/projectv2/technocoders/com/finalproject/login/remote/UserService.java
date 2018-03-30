package projectv2.technocoders.com.finalproject.login.remote;

import projectv2.technocoders.com.finalproject.login.model.ResObj;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by acer on 12/22/2017.
 */

public interface UserService {
    @POST("Access")
    @FormUrlEncoded
    Call<ResObj> savePost(@Field("email") String email, @Field("password") String password);


}
