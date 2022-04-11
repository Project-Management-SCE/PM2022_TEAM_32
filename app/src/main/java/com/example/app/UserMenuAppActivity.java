package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserMenuAppActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView user_menu_header, textView_user_menu;
    ImageView user_flower_image;
    Spinner spinner;
    Button my_profile, logout, select_city_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu_app);

        user_menu_header = findViewById(R.id.user_menu_header);
        textView_user_menu = findViewById(R.id.text_user_menu);
        user_flower_image = findViewById(R.id.user_flower_image);
        my_profile = findViewById(R.id.user_profile_button);
        logout = findViewById(R.id.user_logout);
        spinner = findViewById(R.id.city_spinner);
        select_city_button = findViewById(R.id.select_button);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
       // spinner.setOnItemSelectedListener(this);

        my_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user press on My profile button
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                finish();
            }
        });

        select_city_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //after user select some city for mikveh location

                String userCityChoice = spinner.getSelectedItem().toString();//saving user choice

                //Toast.makeText(UserMenuAppActivity.this, "Chosen city: " + userCityChoice , Toast.LENGTH_SHORT).show();//printing user choice
            }
        });
    }

    @Override
    public void onItemSelected (AdapterView < ? > parent, View view,int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent) {}

}