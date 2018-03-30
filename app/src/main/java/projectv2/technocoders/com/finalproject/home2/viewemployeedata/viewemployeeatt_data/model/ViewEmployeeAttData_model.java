package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.model;


import com.google.gson.annotations.SerializedName;

public class ViewEmployeeAttData_model {

    @SerializedName("fName")
    private String fname;

    @SerializedName("lName")
    private String lname;

    @SerializedName("date")
    private String date;

    @SerializedName("checkIn")
    private String checking;

    @SerializedName("checkOut")
    private String checkout;

    @SerializedName("workingHours")
    private String workinghours;

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
