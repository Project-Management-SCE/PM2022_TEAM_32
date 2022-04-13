package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class OwnerMenuAppActivity extends AppCompatActivity {

    TextView owner_menu_header, owner_menu_text, tollbarTitle;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_menu_app);

        owner_menu_header = findViewById(R.id.admin_menu_header);
        owner_menu_text = findViewById(R.id.owner_menu_text);
        tollbarTitle = findViewById(R.id.toolbar_title);
        calendar = findViewById(R.id.owner_calendar);

        //owner menu has been clicked
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tollbarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.owner_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.owner_profile:
                //owner profile


                return true;
            case R.id.owner_appo:
                //mikvehowner scheduling


                return true;
            case R.id.owner_logoff:
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),SignInActivity.class));
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}