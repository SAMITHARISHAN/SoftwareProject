package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.locationdutyleavearrayadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.model.DutyLeaveData_model;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.ViewEmployeeDutyLeaveLocation;

/**
 * Created by Asus PC on 1/25/2018.
 */

public class Location_Dutyleave_ArrayAdapter  extends RecyclerView.Adapter<Location_Dutyleave_ArrayAdapter.MyViewHolder>{

    private List<DutyLeaveData_model> itemList;
    private Context context;

    public Location_Dutyleave_ArrayAdapter(ArrayList <DutyLeaveData_model> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dutyleave_location_itemlist,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int listposition) {

        holder.fname.setText(itemList.get(listposition).getFname());
        holder.lname.setText(itemList.get(listposition).getLname());
        holder.date.setText(itemList.get(listposition).getDate());
      /*  holder.location.setText(itemList.get(listposition).getLocation());
        holder.b_time.setText(itemList.get(listposition).getAppointmenttime());
        holder.E_time.setText(itemList.get(listposition).getEndtime());*/
        holder.purpose.setText(itemList.get(listposition).getPurpose());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ViewEmployeeDutyLeaveLocation.class);
                intent.putExtra("dlid",itemList.get(listposition).getDlid());
                intent.putExtra("location",itemList.get(listposition).getLocation());
                intent.putExtra("b_time",itemList.get(listposition).getAppointmenttime());
                intent.putExtra("e_time",itemList.get(listposition).getEndtime());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
         return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView fname;
        private TextView lname;
        private TextView date;
      /*  private TextView b_time;
        private TextView E_time;
        private TextView location;*/
        private TextView purpose;
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            fname = (TextView)itemView.findViewById(R.id.dutyleavelocationfname);
            lname = (TextView)itemView.findViewById(R.id.dutyleavelocationlname);
            date = (TextView)itemView.findViewById(R.id.dutyleavelocationdate);
          /*  b_time = (TextView)itemView.findViewById(R.id.dutyleavelocation_btime);
            E_time = (TextView)itemView.findViewById(R.id.dutyleavelocation_etime);
            location = (TextView)itemView.findViewById(R.id.dutyleavelocation);*/
            purpose = (TextView)itemView.findViewById(R.id.dutyleavelocationpurpose);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.dutyleavelocationId);



        }
    }
}
