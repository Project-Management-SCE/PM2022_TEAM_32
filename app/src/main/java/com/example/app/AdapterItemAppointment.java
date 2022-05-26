package com.example.app;

import android.content.Context;
import android.util.Log;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdapterItemAppointment extends ArrayAdapter<dataUser> {


    // constructor for our list view adapter.
    public AdapterItemAppointment(@NonNull Context context, ArrayList<dataUser> dataArrayList) {
        super(context, 0, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
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

        name.setText(data_model.getName());
        address.setText(data_model.getAddress());
        city.setText(data_model.getCity());
        date.setText(data_model.getDate());
        time.setText(data_model.getTime());

//        fStore = FirebaseFirestore.getInstance();
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CollectionReference collRef = fStore.collection("Users").document(userID).collection("Appointments");
//                Map<String, Object> updates = new HashMap<>();
//                updates.put("name", FieldValue.delete());
//
//                collRef.document(meetingID).update(updates).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        //...
//                    }
//                });
//            }
//        });
        return listitemView;

    }

}
