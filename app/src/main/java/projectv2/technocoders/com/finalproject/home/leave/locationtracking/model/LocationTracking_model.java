package projectv2.technocoders.com.finalproject.home.leave.locationtracking.model;


import com.google.gson.annotations.SerializedName;

public class LocationTracking_model {

    @SerializedName("EID")
    private String EID;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    public LocationTracking_model(String eid, String longitude, String latitude) {

        this.EID = eid;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
