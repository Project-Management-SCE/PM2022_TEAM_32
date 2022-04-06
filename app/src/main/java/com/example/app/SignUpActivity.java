package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity<CreateAccountActivity> extends AppCompatActivity {

    private Button LoginButn;
    private Button creatButn;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;

    //connection to DB
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference collectionReference = db.collection("Users");

    private EditText emailEditText;
    private EditText passwordEditText;
    private ProgressBar progressBar;
    private EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        creatButn = findViewById(R.id.create_acct_button);
        progressBar = findViewById(R.id.create_acct_progress);
        passwordEditText = findViewById(R.id.password_account);
        emailEditText = findViewById(R.id.email_account);
        userNameEditText = findViewById(R.id.username_account);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = firebaseAuth.getCurrentUser();
                if (currentUser != null){
                    //user is already logged..
                }else{
                    //no user yet,,
                }

            }
        };


        creatButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(emailEditText.getText()) && !TextUtils.isEmpty(passwordEditText.getText().toString()) && !TextUtils.isEmpty(userNameEditText.getText().toString())) {

                    String profile;
                    String email = emailEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();
                    String username = userNameEditText.getText().toString().trim();

                    //checking user profile
                    boolean adminChecked = ((CheckBox) findViewById(R.id.checkBox1)).isChecked();
                    boolean ownerChecked = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
                    boolean userChecked = ((CheckBox) findViewById(R.id.checkBox3)).isChecked();

                    //if admin profile
                    if (adminChecked) {
                        profile = "admin";
                        CreateAccountActivity(email, password, username, profile);
                    }
                    //if mikveh owner profile
                    else if (ownerChecked) {
                        profile = "owner mikveh";
                        CreateAccountActivity(email, password, username, profile);
                    }
                    //if regular user profile
                    else if (userChecked) {
                        profile = "user";
                        CreateAccountActivity(email, password, username, profile);
                    }
                    //if no one checkbox has been pressed
                    else{
                        Toast.makeText(SignUpActivity.this,
                                "Must choose profile",
                                Toast.LENGTH_LONG)
                                .show();
                    }

                } else {
                    Toast.makeText(SignUpActivity.this,
                            "Empty Fields Not Allowed",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private void CreateAccountActivity(String email, String password , String username, String profile) {
        if (!TextUtils.isEmpty(email)  &&!TextUtils.isEmpty(password) && !TextUtils.isEmpty(username)) {
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                //we take user to AddJournalActivity
                                currentUser = firebaseAuth.getCurrentUser();
                                assert currentUser != null;
                                String currentUserId = currentUser.getUid();

                                // create a user map
                                Map<String , String> userObj = new HashMap<>();
                                userObj.put("userId",currentUserId);
                                userObj.put("username",username);
                                userObj.put("profile", profile);

                                // save
                                collectionReference.add(userObj)
                                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                documentReference.get()
                                                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                                if(task.getResult().exists()){
                                                                    progressBar.setVisibility(View.INVISIBLE);
                                                                    String name = task.getResult()
                                                                            .getString("username");

                                                                    Intent intent =  new Intent(SignUpActivity.this , MenuAppActivity.class);
                                                                    intent.putExtra("username ",name);
                                                                    intent.putExtra("userId", currentUserId);
                                                                    startActivity(intent);



                                                                }else{
                                                                    progressBar.setVisibility(View.INVISIBLE);

                                                                }
                                                            }
                                                        });
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                
                                            }
                                        });

                                //we take user to add
                            }else{
                                //something went wrong
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                }
            });



        }else{


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentUser = firebaseAuth.getCurrentUser();
        firebaseAuth.addAuthStateListener(authStateListener);


    }
}
