package projectv2.technocoders.com.finalproject;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import projectv2.technocoders.com.finalproject.login.model.ResObj;

public class NotificationService extends IntentService {
    private ResObj resObj;
    private DatabaseReference mRootRef;
    private NotificationCompat.Builder notification;
    private int uniqueId = 4445;

    public NotificationService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        loadNotifications();
    }

    private void loadNotifications() {
        //leave notification
        resObj = new LocalStore(getBaseContext()).getUserDetails();
        mRootRef = FirebaseDatabase.getInstance().getReference().child("notifications");
        mRootRef.child("employeeLeave").child(resObj.getEID())
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        NotificationLeaveModel message = dataSnapshot.getValue(NotificationLeaveModel.class);
                        Toast.makeText(getBaseContext(),message.getReason(),Toast.LENGTH_LONG).show();
                        notification = new NotificationCompat.Builder(getBaseContext());
                        notification.setAutoCancel(true);

                        notification.setSmallIcon(R.drawable.ic_dashboard_black_24dp);
                        notification.setTicker("Request for a leave");
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(message.getEmployeeName() + " has requested for a leave");
                        notification.setContentText(message.getReason());
                        notification.setVibrate(new long[]{0});
                        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        notification.setSound(alarmSound);

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(getBaseContext().NOTIFICATION_SERVICE);

                        mNotificationManager.notify(uniqueId, notification.build());

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        NotificationLeaveModel message = dataSnapshot.getValue(NotificationLeaveModel.class);
                        Toast.makeText(getBaseContext(),message.getReason(),Toast.LENGTH_LONG).show();
                        notification = new NotificationCompat.Builder(getBaseContext());
                        notification.setAutoCancel(true);

                        notification.setSmallIcon(R.drawable.ic_dashboard_black_24dp);
                        notification.setTicker("Request for a leave");
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle(message.getEmployeeName() + " has requested for a leave");
                        notification.setContentText(message.getReason());
                        notification.setVibrate(new long[]{0});
                        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        notification.setSound(alarmSound);

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(getBaseContext().NOTIFICATION_SERVICE);

                        mNotificationManager.notify(uniqueId, notification.build());

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        //accept reject notification
        mRootRef.child("managerResponse").child(resObj.getEID())
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        NotificationAcceptRejectModel message = dataSnapshot.getValue(NotificationAcceptRejectModel.class);
                        Toast.makeText(getBaseContext(),message.getStatus(),Toast.LENGTH_LONG).show();
                        notification = new NotificationCompat.Builder(getBaseContext());
                        notification.setAutoCancel(true);

                        notification.setSmallIcon(R.drawable.ic_dashboard_black_24dp);
                        notification.setTicker("Response for your leave");
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle("Response for your leave");
                        notification.setContentText(message.getStatus());
                        notification.setVibrate(new long[]{0});
                        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        notification.setSound(alarmSound);

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(getBaseContext().NOTIFICATION_SERVICE);

                        mNotificationManager.notify(uniqueId, notification.build());


                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        NotificationAcceptRejectModel message = dataSnapshot.getValue(NotificationAcceptRejectModel.class);
                        Toast.makeText(getBaseContext(),message.getStatus(),Toast.LENGTH_LONG).show();
                        notification = new NotificationCompat.Builder(getBaseContext());
                        notification.setAutoCancel(true);

                        notification.setSmallIcon(R.drawable.ic_dashboard_black_24dp);
                        notification.setTicker("Response for your leave");
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle("Response for your leave");
                        notification.setContentText(message.getStatus());
                        notification.setVibrate(new long[]{0});
                        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        notification.setSound(alarmSound);

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(getBaseContext().NOTIFICATION_SERVICE);

                        mNotificationManager.notify(uniqueId, notification.build());

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}
