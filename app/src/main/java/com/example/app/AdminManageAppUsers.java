package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminManageAppUsers extends AppCompatActivity {

    ListView usersList;
    ScrollView sv;
    Button usersButton, ownersButton, mListMikveh;
    ImageButton delete;
    ArrayList<UsersDataModel> dataModalArrayList;
    FirebaseFirestore db;
    String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_manage_app_users);

        // below line is use to initialize our variables
        usersList = findViewById(R.id.usersList);
        sv = findViewById(R.id.scroll_view);
        usersButton = findViewById(R.id.users_button);
        ownersButton = findViewById(R.id.owners_button);
        mListMikveh = findViewById(R.id.mikveh_button);

        dataModalArrayList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();

        // here we are calling a method
        // to load data in our list view.
        usersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = "Users";
                loadDatainListview(choice);
            }
        });

        ownersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice = "Owner";
                loadDatainListview(choice);
            }
        });

        mListMikveh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminManageAppUsers.this, MikvehListActivity.class));
            }
        });
    }

    private void loadDatainListview(String choice) {
        usersButton.setVisibility(View.GONE);
        ownersButton.setVisibility(View.GONE);
        usersList.setVisibility(View.VISIBLE);
        db.collection("Users").get()
        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // after getting the data we are calling on success method
                // and inside this method we are checking if the received
                // query snapshot is empty or not.
                if (!queryDocumentSnapshots.isEmpty()) {
                    // if the snapshot is not empty we are hiding
                    // our progress bar and adding our data in a list.
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list) {
                        // after getting this list we are passing
                        // that list to our object class.
                        String key = d.getId();
                        UsersDataModel dataModal = d.toObject(UsersDataModel.class);
                        dataModal.setID(key);
                        // after getting data from Firebase we are
                        // storing that data in our array list
                        dataModalArrayList.add(dataModal);
                    }
                    // after that we are passing our array list to our adapter class.
                    UsersListAdapter adapter = new UsersListAdapter(AdminManageAppUsers.this, dataModalArrayList);

                    // after passing this array list to our adapter
                    // class we are setting our adapter to our list view.
                    usersList.setAdapter(adapter);
                } else {
                    // if the snapshot is empty we are displaying a toast message.
                    Toast.makeText(AdminManageAppUsers.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // we are displaying a toast message
                // when we get any error from Firebase.
                Toast.makeText(AdminManageAppUsers.this, "Fail to load data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
