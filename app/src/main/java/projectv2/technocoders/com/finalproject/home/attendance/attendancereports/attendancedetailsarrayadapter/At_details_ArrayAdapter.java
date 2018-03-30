package projectv2.technocoders.com.finalproject.home.attendance.attendancereports.attendancedetailsarrayadapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.attendance.attendancereports.model.Attendance_details_model;

public class At_details_ArrayAdapter extends RecyclerView.Adapter <At_details_ArrayAdapter.MyViewHolder>{

    private List<Attendance_details_model> itemList;
    private Context context;

    public At_details_ArrayAdapter(ArrayList<Attendance_details_model> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_attendancedetails_listitem,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int listposition) {

        holder.date.setText(itemList.get(listposition).getDate());
        holder.checking.setText(itemList.get(listposition).getChecking());
        holder.checkout.setText(itemList.get(listposition).getCheckout());
        holder.workinghours.setText(itemList.get(listposition).getWorkinghours());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView checking;
        private TextView checkout;
        private  TextView workinghours;

        public MyViewHolder(View itemView) {
            super(itemView);


            date = (TextView)itemView.findViewById(R.id.dateattendancedetails);
            checking = (TextView)itemView.findViewById(R.id.datechecking);
            checkout = (TextView)itemView.findViewById(R.id.datecheckout);
            workinghours = (TextView)itemView.findViewById(R.id.workinghours);

            date.setTextSize(15);
            checking.setTextSize(15);
            checkout.setTextSize(15);
            workinghours.setTextSize(15);

        }
    }
}
