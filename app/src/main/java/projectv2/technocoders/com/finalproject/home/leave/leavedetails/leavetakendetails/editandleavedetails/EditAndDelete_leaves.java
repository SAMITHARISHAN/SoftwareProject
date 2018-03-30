package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.applyleave.api.APIUrlleave;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.api.APIService_EditandDelete_leaves;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.apideleteleave.APIServise_delete_leaves;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.apideleteleave.model.Delete_leave_model;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.model.EditandDeleteLeave_model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditAndDelete_leaves extends AppCompatActivity {

    private  String lid;
    private Button buttoneditleaveDate;
    private EditText editTextReason;
    private Button buttoneditLeaveSend;
    private Button leavedelete;
    String leavecategory;
    String leavedate;

    private DatePickerDialog.OnDateSetListener mDateSetListner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_and_delete_leaves);

        Bundle bundle = getIntent().getExtras();
        lid = bundle.getString("leave_ID");

        Toast.makeText(EditAndDelete_leaves.this,lid,Toast.LENGTH_LONG).show();

        buttoneditleaveDate = (Button) findViewById(R.id.buttonleaveDate);
        editTextReason = (EditText)findViewById(R.id.editTextReason);
        buttoneditLeaveSend = (Button)findViewById(R.id.ButtonEditLeaveSend);
        leavedelete = (Button) findViewById(R.id.ButtonDeleteLeaveSend);



        Spinner mySpinner  = (Spinner)findViewById(R.id.SpinnerLeaveCategory);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EditAndDelete_leaves.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.leavetypes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){

                    case 1: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 2: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 3: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    case 4: leavecategory = adapterView.getItemAtPosition(i).toString();break;
                    default:break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttongetdate();

        sendeditleavedata();

        deleteleave();


    }

    private void buttongetdate() {


        buttoneditleaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal1 = Calendar.getInstance();
                int year = cal1.get(Calendar.YEAR);
                int month = cal1.get(Calendar.MONTH);
                int day = cal1.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog1 = new DatePickerDialog(
                        EditAndDelete_leaves.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        mDateSetListner1,
                        year, month, day);
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });

        mDateSetListner1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String mt,dy;
                if(month < 10 )
                    mt = "0"+month;
                else mt = String.valueOf(month);

                if(day < 10)
                    dy = "0"+day;
                else dy = String.valueOf(day);

                String date = year + "-" + mt + "-" + dy;
                buttoneditleaveDate.setText(date);
                leavedate = date;
            }
        };


    }

    private void sendeditleavedata() {

        buttoneditLeaveSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String date = leavedate;
                String reason = editTextReason.getText().toString();
                String leave_category = leavecategory;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlleave.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService_EditandDelete_leaves service = retrofit.create(APIService_EditandDelete_leaves.class);

                EditandDeleteLeave_model user = new EditandDeleteLeave_model(date,leave_category,reason);

                retrofit2.Call<EditandDeleteLeave_model> call = service.createUser(

                        lid,
                        user.getDate(),
                        user.getLeavecategory(),
                        user.getReason()
                );

                call.enqueue(new Callback<EditandDeleteLeave_model>() {
                    @Override
                    public void onResponse(Call<EditandDeleteLeave_model> call, Response<EditandDeleteLeave_model> response) {

                        Toast.makeText(EditAndDelete_leaves.this,"Sending Success"+response,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<EditandDeleteLeave_model> call, Throwable t) {

                        Toast.makeText(EditAndDelete_leaves.this,"Sending Success"+t,Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }

    private void deleteleave() {

        leavedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APIUrlleave.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIServise_delete_leaves service = retrofit.create(APIServise_delete_leaves.class);


                Call<Delete_leave_model> call = service.deleteData(lid);
                call.enqueue(new Callback<Delete_leave_model>() {
                    @Override
                    public void onResponse(Call<Delete_leave_model> call, Response<Delete_leave_model> response) {

                        Delete_leave_model delete_leave_model = response.body();
                        String message = delete_leave_model.getMessage();

                        Toast.makeText(EditAndDelete_leaves.this,message,Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Delete_leave_model> call, Throwable t) {

                        Toast.makeText(EditAndDelete_leaves.this,"Sending Fail"+t,Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


    }

}
