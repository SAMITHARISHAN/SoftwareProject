package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/22/2018.
 */

public class UserLeaveTaken {

        @SerializedName("date")
        private String date;

        @SerializedName("leaveCategory")
        private String leavecategory;

        @SerializedName("LID")
        private String lid;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
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
}
