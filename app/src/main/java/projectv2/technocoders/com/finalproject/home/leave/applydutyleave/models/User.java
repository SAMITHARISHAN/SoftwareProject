package projectv2.technocoders.com.finalproject.home.leave.applydutyleave.models;


public class User {
    private  String EID;
    private String date;
    private String appointment_time;
    private String location;
    private String endTime;
    private String purpose;


    public User (String EID, String date, String appointment_time, String location, String endTime, String purpose) {

        this.EID = EID;
        this.date = date;
        this.location = location;
        this.appointment_time = appointment_time;
        this.endTime = endTime;
        this.purpose = purpose;

    }

    public String getEID() {
        return EID;
    }

    public String getDate() {
        return date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public String getLocation() {
        return location;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPurpose() {
        return purpose;
    }


}
