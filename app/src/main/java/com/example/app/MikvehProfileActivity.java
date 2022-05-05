package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MikvehProfileActivity extends AppCompatActivity {
    private TextView mCouncil_txtView;
    private TextView mCity_txtView;
    private TextView mNeighborhood_txtView;
    private TextView mAddress_txtView;
    private TextView mPhone_txtView;
    private TextView mOpeningSummer_txtView;
    private TextView mOpeningWinter_txtView;
    private TextView mOpeningFriday_txtView;
    private TextView mOpeningSaturday_txtView;
    private TextView mAccess_txtView;
    private TextView mAppoint_txtView;
    private TextView mNotes_txtView;
    private Button mBack_btn;

    private String mAddress;
    private String mCity;
    private String mNeighbor;
    private String mReligious_Council;
    private String mOpening_Hours_Summer;
    private String mPhone;
    private String mOwner_ID;
    private String mOpening_Hours_Winter;
    private String mOpening_Hours_Holiday_Eve_Shabat_Eve;
    private String mOpening_Hours_Saturday_Night_Good_Day;
    private String mAccessibility;
    private String mSchedule_Appointment;
    private String mNotes;

    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mikveh_profile);

        key = getIntent().getStringExtra("key");
        mAddress = getIntent().getStringExtra("address");
        mCity = getIntent().getStringExtra("city");
        mNeighbor = getIntent().getStringExtra("neighbor");
        mReligious_Council = getIntent().getStringExtra("religious_Council");
        mOpening_Hours_Summer = getIntent().getStringExtra("opening_Hours_Summer");
        mPhone = getIntent().getStringExtra("phone");
        mOwner_ID = getIntent().getStringExtra("owner_ID");
        mOpening_Hours_Winter = getIntent().getStringExtra("opening_Hours_Winter");
        mOpening_Hours_Holiday_Eve_Shabat_Eve = getIntent().getStringExtra("opening_Hours_Holiday_Eve_Shabat_Eve");
        mOpening_Hours_Saturday_Night_Good_Day = getIntent().getStringExtra("opening_Hours_Saturday_Night_Good_Day");
        mAccessibility = getIntent().getStringExtra("accessibility");
        mSchedule_Appointment = getIntent().getStringExtra("schedule_Appointment");
        mNotes = getIntent().getStringExtra("notes");

        mCouncil_txtView = (TextView) findViewById(R.id.council_txtView);
        mCity_txtView = (TextView) findViewById(R.id.city_txtView);
        mNeighborhood_txtView = (TextView) findViewById(R.id.neighborhood_txtView);
        mAddress_txtView = (TextView) findViewById(R.id.address_txtView);
        mPhone_txtView = (TextView) findViewById(R.id.phone_txtView);
        mOpeningSummer_txtView = (TextView) findViewById(R.id.openingSummer_txtView);
        mOpeningWinter_txtView = (TextView) findViewById(R.id.openingWinter_txtView);
        mOpeningFriday_txtView = (TextView) findViewById(R.id.openingFriday_txtView);
        mOpeningSaturday_txtView = (TextView) findViewById(R.id.openingSaturday_txtView);
        mAccess_txtView = (TextView) findViewById(R.id.access_txtView);
        mAppoint_txtView = (TextView) findViewById(R.id.appoint_txtView);
        mNotes_txtView = (TextView) findViewById(R.id.notes_txtView);
        mBack_btn = (Button) findViewById(R.id.back_btn);

        mCouncil_txtView.setText("Religious council: " + mReligious_Council);
        mCity_txtView.setText("City: " + mCity);
        mNeighborhood_txtView.setText("Neighborhood: " + mNeighbor);
        mAddress_txtView.setText("Address: " + mAddress);
        mPhone_txtView.setText("Phone: " + mPhone);
        mOpeningSummer_txtView.setText("Opening Hours Summer: " + mOpening_Hours_Summer);
        mOpeningWinter_txtView.setText("Opening Hours Winter: " + mOpening_Hours_Winter);
        mOpeningFriday_txtView.setText("Opening Hours Friday: " + mOpening_Hours_Holiday_Eve_Shabat_Eve);
        mOpeningSaturday_txtView.setText("Opening Hours Saturday: " + mOpening_Hours_Saturday_Night_Good_Day);
        mAccess_txtView.setText("Accessibility: " + mAccessibility);
        mAppoint_txtView.setText("Schedule Appointment: " + mSchedule_Appointment);
        mNotes_txtView.setText("Notes: " + mNotes);

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();return;
            }
        });
    }
}