package projectv2.technocoders.com.finalproject.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResObj {

    @SerializedName("EID")
    @Expose
    private String eID;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("emailVerified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("activationCode")
    @Expose
    private String activationCode;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("fName")
    @Expose
    private String fName;
    @SerializedName("lName")
    @Expose
    private String lName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("homeNo")
    @Expose
    private String homeNo;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("jobCategory")
    @Expose
    private String jobCategory;
    @SerializedName("managerId")
    @Expose
    private String managerId;


    public ResObj(String eID, String password, String email, Boolean emailVerified, String activationCode, String dob, String fName, String lName, String gender, String homeNo, String street, String city, String jobCategory, String managerId) {
        this.eID = eID;
        this.password = password;
        this.email = email;
        this.emailVerified = emailVerified;
        this.activationCode = activationCode;
        this.dob = dob;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.homeNo = homeNo;
        this.street = street;
        this.city = city;
        this.jobCategory = jobCategory;
        this.managerId = managerId;
    }

    public String getEID() {
        return eID;
    }

    public void setEID(String eID) {
        this.eID = eID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

}


