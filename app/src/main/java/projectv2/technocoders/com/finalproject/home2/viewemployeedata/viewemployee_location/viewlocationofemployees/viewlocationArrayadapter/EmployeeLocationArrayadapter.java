package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.viewlocationArrayadapter;

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
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.ViewEmployeeDutyLeaveLocation;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.map.LocationTracking_Map;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployee_location.viewlocationofemployees.model.EmployeeLocationTracking_model;


public class EmployeeLocationArrayadapter extends  RecyclerView.Adapter<EmployeeLocationArrayadapter.MyViewHolder>{

    private List<EmployeeLocationTracking_model> itemList;
    private Context context;

    ViewEmployeeDutyLeaveLocation viewLocation;

    public EmployeeLocationArrayadapter(ArrayList<EmployeeLocationTracking_model> itemList, Context context) {

        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_location_tracking_itemlist,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int listposition) {

        String begintime = viewLocation.B_Time;
        String endtime = viewLocation.E_Time;
        String location = viewLocation.Location;

        holder.begintime.setText(begintime);
        holder.endtime.setText(endtime);
        holder.location.setText(location);
        holder.trackingtime.setText(itemList.get(listposition).getTime());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,LocationTracking_Map.class);
                intent.putExtra("latitude",itemList.get(listposition).getLatitude());
                intent.putExtra("longitude",itemList.get(listposition).getLongitude());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView begintime;
        private TextView endtime;
        private TextView location;
        private TextView trackingtime;

        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            begintime = (TextView)itemView.findViewById(R.id.locationbegintime);
            endtime = (TextView)itemView.findViewById(R.id.locationendtime);
            location = (TextView)itemView.findViewById(R.id.trackinglocation);
            trackingtime = (TextView)itemView.findViewById(R.id.trackingtime);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.locationtracking_layoutID);

            begintime.setTextSize(15);
            endtime.setTextSize(15);
            location.setTextSize(15);
            trackingtime.setTextSize(15);
        }
    }
}
