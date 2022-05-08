package com.example.app;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     ImageView image;
     Button getStartedButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//??
        setContentView(R.layout.activity_main);
        getStartedButton = findViewById(R.id.startButton);

        getStartedButton.setOnClickListener(new View.OnClickListener() {//?-View s'occupe du graphic interface
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));

            }
        });
    }
}