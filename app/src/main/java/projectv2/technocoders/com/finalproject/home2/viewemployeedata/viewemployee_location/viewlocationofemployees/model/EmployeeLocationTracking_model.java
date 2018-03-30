package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/26/2018.
 */

public class EmployeeLocationTracking_model {

    @SerializedName("time")
    private String time;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
