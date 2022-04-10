package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class UserMenuAppActivity extends AppCompatActivity {

    TextView user_menu_header, textView_user_menu;
    ImageView user_menu_icon;
    Spinner spinner;
    Button select_city_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu_app);

        user_menu_header = findViewById(R.id.user_menu_header);
        textView_user_menu = findViewById(R.id.text_user_menu);
        user_menu_icon = findViewById(R.id.user_menu_icon);
        spinner = findViewById(R.id.city_spinner);
        select_city_button = findViewById(R.id.select_button);

    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.cities_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }






//    public void Logout(View view) {
//        FirebaseAuth.getInstance().signOut();//logout
//        startActivity(new Intent(getApplicationContext(), SignInActivity.class));
//        finish();
//
//    }

}