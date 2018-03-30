package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/25/2018.
 */

public class DutyLeaveData_model {

    @SerializedName("date")
    private String date;

    @SerializedName("appointmentTime")
    private String appointmenttime;

    @SerializedName("endTime")
    private String endtime;

    @SerializedName("location")
    private String location;

    @SerializedName("purpose")
    private String purpose;

    @SerializedName("fName")
    private String fname;

    @SerializedName("lName")
    private String lname;

    @SerializedName("DLID")
    @Expose
    private String dlid;

    public String getDlid() {
        return dlid;
    }

    public void setDlid(String dlid) {
        this.dlid = dlid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

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
}
