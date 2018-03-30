package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.apideleteleave;


import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.apideleteleave.model.Delete_leave_model;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface APIServise_delete_leaves {

    @DELETE("api/Leaves/{id}")
    Call<Delete_leave_model> deleteData(@Path("id") String id);


}
