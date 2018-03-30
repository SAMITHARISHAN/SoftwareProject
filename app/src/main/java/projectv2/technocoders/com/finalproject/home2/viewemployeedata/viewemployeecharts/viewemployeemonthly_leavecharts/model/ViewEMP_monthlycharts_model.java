package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeecharts.viewemployeemonthly_leavecharts.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/31/2018.
 */

public class ViewEMP_monthlycharts_model {

    @SerializedName("Monday")
    private String monday;

    @SerializedName("Tuesday")
    private String tuesday;

    @SerializedName("Wednesday")
    private String wednesday;

    @SerializedName("Thursday")
    private String thursday;

    @SerializedName("Friday")
    private String friday;

    @SerializedName("Saturday")
    private String saturday;

    @SerializedName("Sunday")
    private String sunday;

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
