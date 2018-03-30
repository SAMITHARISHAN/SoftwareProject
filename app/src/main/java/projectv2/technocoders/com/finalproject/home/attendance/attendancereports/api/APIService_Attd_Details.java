package projectv2.technocoders.com.finalproject.home.attendance.attendancereports.api;

import java.util.List;

import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.model.Attendance_details_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface APIService_Attd_Details {

    @GET("api/Attendance")
    Call<List<Attendance_details_model>> getattendanceData(@Query("EID") String EID, @Query("startDate") String startdate, @Query("endDate") String enddate);


}
