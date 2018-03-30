package projectv2.technocoders.com.finalproject.home.leave.leavecharts.model;

import com.google.gson.annotations.SerializedName;


public class Individual_leave_charts_model {

    @SerializedName("leaveCategory")
    private   String leavecategory;

    @SerializedName("takenCount")
    private  String takencount;

    @SerializedName("leftCount")
    private  String leftcount;

    public String getLeavecategory() {
        return leavecategory;
    }

    public void setLeavecategory(String leavecategory) {
        this.leavecategory = leavecategory;
    }

    public String getTakencount() {
        return takencount;
    }

    public void setTakencount(String takencount) {
        this.takencount = takencount;
    }

    public String getLeftcount() {
        return leftcount;
    }

    public void setLeftcount(String leftcount) {
        this.leftcount = leftcount;
    }
}
