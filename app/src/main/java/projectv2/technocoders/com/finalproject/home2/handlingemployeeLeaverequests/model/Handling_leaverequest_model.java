package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.model;

import com.google.gson.annotations.SerializedName;

public class Handling_leaverequest_model {

    @SerializedName("fName")
    private String fname;

    @SerializedName("lName")
    private String lname;

    @SerializedName("leaveCategory")
    private String leavecategory;

    @SerializedName("reason")
    private String reason;

    @SerializedName("status")
    private String status;

    @SerializedName("date")
    private String date;

    @SerializedName("APID")
    private String apid;

    @SerializedName("EID")
    private String EID;

    public String getEID() {
        return EID;
    }

    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
