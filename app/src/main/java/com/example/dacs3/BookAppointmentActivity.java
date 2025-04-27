package com.example.dacs3;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    MaterialTextView ed1, ed2, ed3, ed4,ed5;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.textViewAppTile);
        ed1 = findViewById(R.id.editTextDTFullName);
        ed2 = findViewById(R.id.editTextDTPincode);
        ed4 = findViewById(R.id.editTextDTAddress);
        ed3 = findViewById(R.id.editTextDTContact);
        ed5 = findViewById(R.id.editTextDTFees);
        dateButton = findViewById(R.id.buttonCartAppDate);
        timeButton = findViewById(R.id.buttonCartTime);
        btnBook = findViewById(R.id.buttonDTBooking);
        ImageView btnBack = findViewById(R.id.buttonAppBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String exp = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String address = it.getStringExtra("text5");
        String fees = it.getStringExtra("text6");



        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText("" + exp );
        ed3.setText(contact);
        ed4.setText(address);
        ed5.setText(fees);


        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
//            }
//        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db = new Database(getApplicationContext(), "healthcare",null, 1);
                SharedPreferences sharedpreferences  = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                if(db.checkAppointmentExits(username,title+" => "+fullname, address, contact,dateButton.getText().toString(),timeButton.getText().toString())==1){
                    Toast.makeText(getApplicationContext(),"Appoint alrealdy booked", Toast.LENGTH_LONG).show();
                }else {
                    db.addOrder(username,title+" => "+fullname,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fees),"appointment");
                    Toast.makeText(getApplicationContext(), "Your appointmnet is done successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(BookAppointmentActivity.this, MainActivity.class));
                }
            }
        });
    }

//
        private void initDatePicker () {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    i1 = i1 + 1;
                    dateButton.setText(i2 + "/" + i1 + "/" + i);
                }
            };
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            int style = AlertDialog.THEME_HOLO_DARK;
            datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
            datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 864000000);
        }
//
        private void initTimePicker () {
            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    timeButton.setText(i + ":" + i1);
                }
            };
            Calendar cal = Calendar.getInstance();
            int hrs = cal.get(Calendar.HOUR);
            int mins = cal.get(Calendar.MINUTE);

            int style = AlertDialog.THEME_HOLO_DARK;
            timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);
    }
}
