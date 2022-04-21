package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class UserEditProfile extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText profileUserName,profileEmail;
    Button saveBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user_profile);

        profileUserName = findViewById(R.id.profileFullName);
        profileEmail = findViewById(R.id.profileEmailAddress);
        saveBtn = findViewById(R.id.saveProfileInfo);



    }

}

