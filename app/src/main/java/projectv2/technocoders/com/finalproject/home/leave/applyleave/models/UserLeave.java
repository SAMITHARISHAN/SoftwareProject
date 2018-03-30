package projectv2.technocoders.com.finalproject.home.leave.applyleave.models;


public class UserLeave {

    private  String EID;
    private String date;
    private String reason;
    private String leavecategory;



    public UserLeave (String EID, String date, String reason, String leavecategory) {

        this.EID = EID;
        this.date = date;
        this.reason = reason;
        this.leavecategory = leavecategory;

    }

    public String getEID() {

        return EID;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getLeavecategory() {
        return leavecategory;
    }

}

