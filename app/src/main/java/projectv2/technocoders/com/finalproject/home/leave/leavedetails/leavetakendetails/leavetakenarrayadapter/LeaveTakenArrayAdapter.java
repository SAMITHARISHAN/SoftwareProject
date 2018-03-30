package projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.leavetakenarrayadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.editandleavedetails.EditAndDelete_leaves;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.leavetakendetails.model.UserLeaveTaken;

public class LeaveTakenArrayAdapter extends RecyclerView.Adapter <LeaveTakenArrayAdapter.MyViewHolder>{

    private List<UserLeaveTaken> itemList;
    private Context context;

    public LeaveTakenArrayAdapter(List<UserLeaveTaken> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leavetakenlist,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int listposition) {
        holder.date.setText(itemList.get(listposition).getDate());
        holder.leavetype.setText(itemList.get(listposition).getLeavecategory());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,EditAndDelete_leaves.class);
                intent.putExtra("leave_ID",itemList.get(listposition).getLid());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        private TextView date;
        private TextView leavetype;
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            date = (TextView)itemView.findViewById(R.id.leavetakendate);
            leavetype = (TextView)itemView.findViewById(R.id.leavetakentype);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.leavetaken_linearID);
        }
    }
}
