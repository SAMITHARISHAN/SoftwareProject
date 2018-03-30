package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.model;

/**
 * Created by Asus PC on 2/2/2018.
 */

public class EditandDeleteLeave_model {


    private String date;
    private String reason;
    private String leaveCategory;



    public EditandDeleteLeave_model (String date, String leavecategory, String reason) {

        this.date = date;
        this.reason = reason;
        this.leaveCategory = leavecategory;

    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getLeavecategory() {
        return leaveCategory;
    }
}
