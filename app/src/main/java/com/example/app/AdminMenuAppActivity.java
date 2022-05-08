package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class AdminMenuAppActivity extends AppCompatActivity {

    TextView admin_menu_header, tollbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_app);

        admin_menu_header = findViewById(R.id.admin_menu_header);
        tollbarTitle = findViewById(R.id.toolbar_title);

        //admin menu has been clicked
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        tollbarTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.adm_profile:
                adminData();
                return true;

            case R.id.adm_manage:
                admManage();
                return true;

//            case R.id.adm_settings:
//                //settings
//                return true;

            case R.id.adm_logoff:
                logout();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void adminData() {
        startActivity(new Intent(AdminMenuAppActivity.this, AdminProfile.class));
    }

    public void admManage() {
        startActivity(new Intent(AdminMenuAppActivity.this, AdminManageAppUsers.class));

    }

    public void logout() {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
        finish();
    }
}
