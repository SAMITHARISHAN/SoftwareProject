package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 1/30/2018.
 */

public class LeaveAcceptReject_model {

    @SerializedName("status")
    private String status;

    public LeaveAcceptReject_model(String status) {

        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
