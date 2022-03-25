package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText enterEmail,enterPass;
    private TextView emails,pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterEmail =findViewById(R.id.enteremail);
        enterPass = findViewById(R.id.enterpass);
        emails = findViewById(R.id.emails);


    }
    public void signIn (View view){
        Log.d("MainActivity" ,"SignIn");
    }

    public void addemails(View view) {
        emails.setText(String.format("email:%s", enterEmail.getText().toString().trim()));
        emails.setVisibility(View.VISIBLE);



    }
}