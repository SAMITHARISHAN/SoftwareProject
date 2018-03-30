package projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.handling_leaverequest_arrayadapter;


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
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.accept_reject_EMP_leaves.Employee_Accept_Reject_Leaves;
import projectv2.technocoders.com.finalproject.home2.handlingemployeeLeaverequests.model.Handling_leaverequest_model;

public class Handling_leaverequest_arrayadapter extends RecyclerView.Adapter<Handling_leaverequest_arrayadapter.MyViewHolder>  {

    private List<Handling_leaverequest_model> itemList;
    private Context context;

    public Handling_leaverequest_arrayadapter(ArrayList<Handling_leaverequest_model> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_handling_leave_request_itemlist,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int listposition) {

        holder.fname.setText(itemList.get(listposition).getFname());
        holder.lname.setText(itemList.get(listposition).getLname());
        holder.date.setText(itemList.get(listposition).getDate());
        holder.status.setText(itemList.get(listposition).getStatus());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Employee_Accept_Reject_Leaves.class);
                intent.putExtra("leave_category",itemList.get(listposition).getLeavecategory());
                intent.putExtra("reason",itemList.get(listposition).getReason());
                intent.putExtra("APID",itemList.get(listposition).getApid());
                intent.putExtra("EID",itemList.get(listposition).getEID());
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
        private TextView status;

        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {

            super(itemView);

            fname = (TextView)itemView.findViewById(R.id.leavehandlingfname);
            lname = (TextView)itemView.findViewById(R.id.leavehandlinglname);
            date = (TextView)itemView.findViewById(R.id.leavehandlingdate);
            status = (TextView)itemView.findViewById(R.id.leavehandlingstatus);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.leavehandling_layoutID);

            fname.setTextSize(15);
            lname.setTextSize(15);
            date.setTextSize(15);
            status.setTextSize(15);

        }
    }
}
