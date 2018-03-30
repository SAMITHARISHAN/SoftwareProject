package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import projectv2.technocoders.com.finalproject.LocalStore;
import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.api.APIUrlLeavetaken;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.api.APIService_leave_acceptreject;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.model.LeaveAcceptReject_model;
import projectv2.technocoders.com.finalproject.login.model.ResObj;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Employee_Accept_Reject_Leaves extends AppCompatActivity {

    private String leavetype;
    private String reason;
    private String apid;
    private String EID;
    private TextView requestleavetype;
    private TextView requestreason;
    Button buttonleaveaccept;
    Button buttonleavereject;
    String status;
    private DatabaseReference mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__accept__reject__leaves);

        mRootRef = FirebaseDatabase.getInstance().getReference();

        buttonleaveaccept = (Button)findViewById(R.id.buttonaccept);
        buttonleavereject = (Button)findViewById(R.id.buttonreject);

        Bundle bundle = getIntent().getExtras();
        leavetype = bundle.getString("leave_category");
        reason = bundle.getString("reason");
        apid = bundle.getString("APID");
        EID = bundle.getString("EID");

        requestleavetype = (TextView)findViewById(R.id.requestleavetype);
        requestreason = (TextView)findViewById(R.id.requestreason);

        requestleavetype.setText(leavetype);
        requestreason.setText(reason);

        Buttonleaveaccept();
        ButtonleaveReject();

    }

    private void Buttonleaveaccept() {

        buttonleaveaccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                status = "Accepted";

                //sending notification
                LocalStore localStore = new LocalStore(getApplicationContext());
                ResObj resObj = localStore.getUserDetails();;

                String notificationReceiverRef = "notifications/" + "managerResponse/" + EID + "/" + resObj.getEID();

                Map messageMapReceiver = new HashMap();
                messageMapReceiver.put("status","accepted");

                Map messageUserMap = new HashMap();
                messageUserMap.put(notificationReceiverRef, messageMapReceiver);

                mRootRef.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if(databaseError != null){
                            Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });



                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlLeavetaken.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService_leave_acceptreject service = retrofit.create(APIService_leave_acceptreject.class);

                LeaveAcceptReject_model leaveacceptreject = new LeaveAcceptReject_model(status);

                Call<LeaveAcceptReject_model> call = service.getleaveacceptreject(apid,
                        leaveacceptreject.getStatus());

                call.enqueue(new Callback<LeaveAcceptReject_model>() {
                    @Override
                    public void onResponse(Call<LeaveAcceptReject_model> call, Response<LeaveAcceptReject_model> response) {

                        Toast.makeText(Employee_Accept_Reject_Leaves.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LeaveAcceptReject_model> call, Throwable t) {

                        Toast.makeText(Employee_Accept_Reject_Leaves.this,"Sending fail" + t,Toast.LENGTH_SHORT).show();

                    }
                });
                Toast.makeText(Employee_Accept_Reject_Leaves.this,"Leave Accepted",Toast.LENGTH_SHORT).show();
            }

        });


    }

    private void ButtonleaveReject() {

        buttonleavereject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                status = "Rejected";

                //sending notification
                LocalStore localStore = new LocalStore(getApplicationContext());
                ResObj resObj = localStore.getUserDetails();

                String notificationReceiverRef = "notifications/" + "managerResponse/" + EID + "/" + resObj.getEID();

                Map messageMapReceiver = new HashMap();
                messageMapReceiver.put("status","rejected");

                Map messageUserMap = new HashMap();
                messageUserMap.put(notificationReceiverRef, messageMapReceiver);

                mRootRef.updateChildren(messageUserMap, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                        if(databaseError != null){
                            Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });




                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlLeavetaken.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService_leave_acceptreject service = retrofit.create(APIService_leave_acceptreject.class);

                LeaveAcceptReject_model leaveacceptreject = new LeaveAcceptReject_model(status);

                Call<LeaveAcceptReject_model> call = service.getleaveacceptreject(apid,
                        leaveacceptreject.getStatus());

                call.enqueue(new Callback<LeaveAcceptReject_model>() {
                    @Override
                    public void onResponse(Call<LeaveAcceptReject_model> call, Response<LeaveAcceptReject_model> response) {

                        Toast.makeText(Employee_Accept_Reject_Leaves.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LeaveAcceptReject_model> call, Throwable t) {

                        Toast.makeText(Employee_Accept_Reject_Leaves.this,"Sending fail" + t,Toast.LENGTH_SHORT).show();

                    }
                });
                Toast.makeText(Employee_Accept_Reject_Leaves.this,"Leave Rejected",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
