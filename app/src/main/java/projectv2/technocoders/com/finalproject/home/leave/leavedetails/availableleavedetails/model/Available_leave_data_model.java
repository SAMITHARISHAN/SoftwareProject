package projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/25/2018.
 */

public class Available_leave_data_model {

    @SerializedName("leaveCategory")
    private String leavecatagory;

    @SerializedName("maxAllowed")
    private String availableleaves;


    public String getLeavecatagory() {
        return leavecatagory;
    }

    public void setLeavecatagory(String leavecatagory) {
        this.leavecatagory = leavecatagory;
    }

    public String getAvailableleaves() {
        return availableleaves;
    }

    public void setAvailableleaves(String availableleaves) {
        this.availableleaves = availableleaves;
    }
}
