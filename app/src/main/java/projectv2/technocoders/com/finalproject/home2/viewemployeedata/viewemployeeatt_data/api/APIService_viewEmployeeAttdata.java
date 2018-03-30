package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.api;


import java.util.List;

import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.model.ViewEmployeeAttData_model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService_viewEmployeeAttdata {

    @GET("api/Attendance/GetManaged")
    Call<List<ViewEmployeeAttData_model>> getviewEMPattendanceData(@Query("ManagerID") String EID, @Query("startDate") String startdate, @Query("endDate") String enddate);


}
