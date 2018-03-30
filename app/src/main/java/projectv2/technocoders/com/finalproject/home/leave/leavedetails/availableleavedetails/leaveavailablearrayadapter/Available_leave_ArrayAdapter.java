package projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.leaveavailablearrayadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home.leave.leavedetails.availableleavedetails.model.Available_leave_data_model;


/**
 * Created by Asus PC on 1/25/2018.
 */

public class Available_leave_ArrayAdapter extends RecyclerView.Adapter <Available_leave_ArrayAdapter.MyViewHolder>{


    private List<Available_leave_data_model> itemList;
    private Context context;

    public Available_leave_ArrayAdapter(List<Available_leave_data_model> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_leaveavailable_list,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int listposition) {

        holder.leavetype.setText(itemList.get(listposition).getLeavecatagory());
        holder.remainingleaves.setText(itemList.get(listposition).getAvailableleaves());

    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView remainingleaves;
        private TextView leavetype;

        public MyViewHolder(View itemView) {
            super(itemView);

            leavetype = (TextView)itemView.findViewById(R.id.availableleaveType);
            remainingleaves = (TextView)itemView.findViewById(R.id.remainingleaves);

        }
    }
}
