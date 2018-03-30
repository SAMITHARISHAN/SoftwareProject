package projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.viewemployeeatt_Arrayadapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import projectv2.technocoders.com.finalproject.R;
import projectv2.technocoders.com.finalproject.home2.viewemployeedata.viewemployeeatt_data.model.ViewEmployeeAttData_model;


public class ViewEmployeeAtt_Arrayadapter  extends RecyclerView.Adapter <ViewEmployeeAtt_Arrayadapter.MyViewHolder>{

    private List<ViewEmployeeAttData_model> itemList;
    private Context context;

    public ViewEmployeeAtt_Arrayadapter(ArrayList<ViewEmployeeAttData_model> itemList, Context context) {
        // listItemLayout = layoutId;
        this.itemList = itemList;
        this.context = context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_employee_attdata_itemlist,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int listposition) {

        holder.fname.setText(itemList.get(listposition).getFname());
        holder.lname.setText(itemList.get(listposition).getLname());
        holder.date.setText(itemList.get(listposition).getDate());
        holder.checking.setText(itemList.get(listposition).getChecking());
        holder.checkout.setText(itemList.get(listposition).getCheckout());
        holder.workinghours.setText(itemList.get(listposition).getWorkinghours());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView fname;
        private TextView lname;
        private TextView date;
        private TextView checking;
        private TextView checkout;
        private TextView workinghours;

        public MyViewHolder(View itemView) {
            super(itemView);

            fname = (TextView)itemView.findViewById(R.id.viewemployeeattdatafname);
            lname = (TextView)itemView.findViewById(R.id.viewemployeeattdatalname);
            date = (TextView)itemView.findViewById(R.id.viewemployeeattdate);
            checking = (TextView)itemView.findViewById(R.id.viewemployeeattchecking);
            checkout = (TextView)itemView.findViewById(R.id.viewemployeeattcheckout);
            workinghours = (TextView)itemView.findViewById(R.id.viewemployeeworkinghours);

            fname.setTextSize(12);
            lname.setTextSize(12);
            date.setTextSize(12);
            checking.setTextSize(12);
            checkout.setTextSize(12);
            workinghours.setTextSize(12);

        }
    }
}
