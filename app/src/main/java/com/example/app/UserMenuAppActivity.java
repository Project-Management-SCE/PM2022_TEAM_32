package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
public class UserMenuAppActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView user_menu_header, textView_user_menu, tollbarTitle;
    ImageView user_flower_image;
    Spinner spinner;
    Button select_city_button;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu_app);

        user_menu_header = findViewById(R.id.admin_menu_header);
        textView_user_menu = findViewById(R.id.text_user_menu);
        user_flower_image = findViewById(R.id.user_flower_image);
        spinner = findViewById(R.id.city_spinner);
        select_city_button = findViewById(R.id.select_button);
        fAuth = FirebaseAuth.getInstance();

        //user menu has been clicked
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tollbarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                userData();
                return true;
//            case R.id.item2:
//                showHelp();
//                return true;
            case R.id.item3:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void userData() {
        startActivity(new Intent(UserMenuAppActivity.this,UserEditProfile.class));
//        Intent intent = new Intent(this, UserEditProfile.class);
//        startActivity(intent);
    }

//    public void userAppo(MenuItem item) {
//        //create user appoitements function
//    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
        finish();
    }

    @Override
    public void onItemSelected (AdapterView < ? > parent, View view,int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent) {}

}