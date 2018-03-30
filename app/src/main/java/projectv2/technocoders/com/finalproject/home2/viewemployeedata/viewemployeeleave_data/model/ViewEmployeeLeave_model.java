package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/28/2018.
 */

public class ViewEmployeeLeave_model {

    @SerializedName("fName")
    private String fname;

    @SerializedName("lName")
    private String lname;

    @SerializedName("date")
    private String date;

    @SerializedName("leaveCategory")
    private String leavecategory;

    @SerializedName("reason")
    private String reason;

    @SerializedName("status")
    private String status;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeavecategory() {
        return leavecategory;
    }

    public void setLeavecategory(String leavecategory) {
        this.leavecategory = leavecategory;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
