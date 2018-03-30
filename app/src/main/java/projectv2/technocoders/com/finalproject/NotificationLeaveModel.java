package projectv2.technocoders.com.finalproject;

/**
 * Created by DELL on 1/30/2018.
 * All Rights Reserved by MLPJ©
 */

public class NotificationLeaveModel {
    private String employeeName;
    private String date;
    private String reason;
    private String leaveCtaegory;

    public NotificationLeaveModel() {
    }

    public NotificationLeaveModel(String employeeName, String date, String reason, String leaveCtaegory) {
        this.employeeName = employeeName;
        this.date = date;
        this.reason = reason;
        this.leaveCtaegory = leaveCtaegory;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }

    public String getLeaveCtaegory() {
        return leaveCtaegory;
    }
}
