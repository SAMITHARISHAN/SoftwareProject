package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.viewemployeeleavedataArrayadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeleave_data.model.ViewEmployeeLeave_model;


public class ViewEMPleave_Data_Arrayadapter extends  RecyclerView.Adapter  <ViewEMPleave_Data_Arrayadapter.MyViewHolder>{

    private List <ViewEmployeeLeave_model> itemList;
    Context context;


    public ViewEMPleave_Data_Arrayadapter(ArrayList<ViewEmployeeLeave_model> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_viewemployee_leavedata_itemlist,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int listposition) {

        holder.fname.setText(itemList.get(listposition).getFname());
        holder.lname.setText(itemList.get(listposition).getLname());
        holder.date.setText(itemList.get(listposition).getDate());
        holder.leavetype.setText(itemList.get(listposition).getLeavecategory());
        holder.reason.setText(itemList.get(listposition).getReason());
        holder.status.setText(itemList.get(listposition).getStatus());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView fname;
        private TextView lname;
        private TextView date;
        private TextView leavetype;
        private TextView reason;
        private TextView status;

        public MyViewHolder(View itemView) {
            super(itemView);

            fname = (TextView)itemView.findViewById(R.id.viewemployeeleavefname);
            lname = (TextView)itemView.findViewById(R.id.viewemployeeleavelname);
            date = (TextView)itemView.findViewById(R.id.viewemployeeleavedate);
            leavetype = (TextView)itemView.findViewById(R.id.viewemployeeleabvetype);
            reason = (TextView)itemView.findViewById(R.id.viewemployeeleavereason);
            status = (TextView)itemView.findViewById(R.id.viewemployeeleavestatus);

            date.setTextSize(11);
            fname.setTextSize(11);
            reason.setTextSize(11);
            lname.setTextSize(11);
            status.setTextSize(11);
            leavetype.setTextSize(11);


        }
    }
}
