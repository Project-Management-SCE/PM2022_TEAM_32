package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UsersListAdapter extends ArrayAdapter<UsersDataModel> {

    // constructor for our list view adapter.
    public UsersListAdapter(@NonNull Context context, ArrayList<UsersDataModel> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // below line is use to inflate the
        // layout for our item of list view.
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.users_list_item, parent, false);
        }

        // after inflating an item of listview item
        // we are getting data from array list inside
        // our modal class.
        UsersDataModel dataModal = getItem(position);

        // initializing our UI components of list view item.
        TextView userName = listitemView.findViewById(R.id.username_txt);
        TextView profile = listitemView.findViewById(R.id.profile_txt);
        TextView email = listitemView.findViewById(R.id.email_txt);
        Button delete = listitemView.findViewById(R.id.delete_button);

        // after initializing our items we are
        // setting data to our view.
        // below line is use to set data to our text view.
        userName.setText(dataModal.getUsername());
        profile.setText(dataModal.getProfile());
        email.setText(dataModal.getEmail());


        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on the item click on our list view.
                // we are displaying a toast message.
                Toast.makeText(getContext(), "Item clicked is : " + dataModal.getUsername(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;

    }

}
