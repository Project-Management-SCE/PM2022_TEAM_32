package com.example.app;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AdapterItemappointment extends RecyclerView.Adapter<AdapterItemappointment.ItemViewHolder> {
    Context context;
    ArrayList<dataUser> dataUserArrayList;
    Locale id = new Locale("in","ID");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy",id);

    public AdapterItemappointment (Context context, ArrayList<dataUser> dataUserArrayList) {
        this.context = context;
        this.dataUserArrayList = dataUserArrayList;
    }


    @NonNull
    @Override
    public AdapterItemappointment .ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull AdapterItemappointment .ItemViewHolder holder, int position) {
        holder.viewBind(dataUserArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataUserArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView my_name, txt_date_item,txt_time_item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            my_name = itemView.findViewById(R.id.my_name);
            txt_date_item = itemView.findViewById(R.id.txt_date_item);
            txt_time_item = itemView.findViewById(R.id.txt_time_item);

        }


        public void viewBind(dataUser dataUser) {
            my_name.setText(dataUser.getName());
            txt_time_item.setText(dataUser.getTime());
           txt_date_item.setText(simpleDateFormat.format(dataUser.getDate()));
        }
    }
}
