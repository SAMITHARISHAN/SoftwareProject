package projectv2.technocoders.com.finalproject.home.attendance.attendancereports.model;


import com.google.gson.annotations.SerializedName;

public class Attendance_details_model {

    @SerializedName("date")
    private String date;

    @SerializedName("checkIn")
    private String checking;

    @SerializedName("checkOut")
    private String checkout;

    @SerializedName("workingHours")
    private String workinghours;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChecking() {
        return checking;
    }

    public void setChecking(String checking) {
        this.checking = checking;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(String workinghours) {
        this.workinghours = workinghours;
    }
}
