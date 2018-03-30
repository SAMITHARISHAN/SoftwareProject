package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.apideleteleave.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus PC on 2/2/2018.
 */

public class Delete_leave_model {

    @SerializedName("Message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
