package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterItemAppointment extends ArrayAdapter<dataUser> {

    // constructor for our list view adapter.
    public AdapterItemAppointment(@NonNull Context context, ArrayList<dataUser> dataArrayList) {
        super(context, 0, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }

        dataUser data_model = getItem(position);

        // initializing our UI components of list view item.
        TextView name = listitemView.findViewById(R.id.meetingUsername);
        TextView address = listitemView.findViewById(R.id.meetingAddress);
        TextView city = listitemView.findViewById(R.id.meetingCity);
        TextView date = listitemView.findViewById(R.id.txt_date_item);
        TextView time = listitemView.findViewById(R.id.txt_time_item);
        ImageButton delete = listitemView.findViewById(R.id.imageView);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        name.setText(data_model.getName());
        address.setText(data_model.getAddress());
        city.setText(data_model.getCity());
        date.setText(data_model.getDate());
        time.setText(data_model.getTime());


//        listitemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // on the item click on our list view.
//                // we are displaying a toast message.
//                //Toast.makeText(getContext(), "Item clicked is : " + data_user.getUsername(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return listitemView;

    }

}
