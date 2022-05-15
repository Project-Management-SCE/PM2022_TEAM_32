package com.example.app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class MikvehProfileActivity extends AppCompatActivity {
    ArrayList<dataUser> list = new ArrayList<>();
    AdapterItemappointment adapterItem;
    Date realtime;
    Button dateButton,saveData;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    EditText dateTextET, nameText;
    Spinner spinner;
    Context context;
    AlertDialog builderAlert;
    LayoutInflater layoutInflater;
    View showInput;
    FloatingActionButton fab_add;
    RecyclerView recyclerView;


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
    //private String mSchedule_Appointment;
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
        //mSchedule_Appointment = getIntent().getStringExtra("schedule_Appointment");
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
        //mAppoint_txtView = (TextView) findViewById(R.id.appoint_txtView);
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
        //mAppoint_txtView.setText("Schedule Appointment: " + mSchedule_Appointment);
        mNotes_txtView.setText("Notes: " + mNotes);


        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();return;
            }
        });

        fab_add = findViewById(R.id.fab_add);
        context = this;
        recyclerView = findViewById(R.id.recyclerView);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputData();
            }
        });

        //showData();


    }

    private void inputData() {
        builderAlert = new AlertDialog.Builder(context).create();
        layoutInflater = getLayoutInflater();
        showInput = layoutInflater.inflate(R.layout.input_layout, null);
        builderAlert.setView(showInput);

        nameText = showInput.findViewById(R.id.et_name);
        spinner = showInput.findViewById(R.id.time_spinner);
        dateButton = showInput.findViewById(R.id.btnDate);
        dateTextET = showInput.findViewById(R.id.et_date);
        saveData = showInput.findViewById(R.id.saveData);
        builderAlert.show();

        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.times_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });


        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String date = dateTextET.getText().toString();
                if (name.isEmpty()) {
                    nameText.setError("empty");
                    nameText.requestFocus();

                } else {
                    database.child("appointments").child(name).setValue(new dataUser(
                            name,date,realtime.getTime()

                    )).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(context, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                            builderAlert.dismiss();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                            builderAlert.dismiss();
                        }
                    });

                }
            }
        });

    }
    private void handleDateButton() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                String dateText = DateFormat.format("EEEE, MMM d, yyyy", calendar1).toString();

                dateTextET.setText(dateText);
            }
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();

    }

    private void showData() {
        database.child("appointments").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                showLisener(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showLisener(DataSnapshot snapshot) {
        list.clear();
        for (DataSnapshot item : snapshot.getChildren()) {
            dataUser user = item.getValue(dataUser.class);
            list.add(user);
        }
        adapterItem = new AdapterItemappointment(context, list);
        recyclerView.setAdapter(adapterItem);
    }




}