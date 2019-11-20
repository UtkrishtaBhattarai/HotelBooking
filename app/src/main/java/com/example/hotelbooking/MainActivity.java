package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.chrono.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


import java.time.*;

import android.widget.Toast;

import java.util.Date;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Spinner spinlocation, spinroom;
    TextView tvindate, tvoutdate;
    Button btncalc;
    int year1=0, year2=0;
    int month1=0, month2=0;
    int day1=0, day2=0;
    Button simpledatepicker1, simpledatepicker2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinlocation = findViewById(R.id.spinlocation);
        spinroom = findViewById(R.id.spinroom);
        tvindate = findViewById(R.id.tvindate);
        tvoutdate = findViewById(R.id.tvoutdate);
        simpledatepicker1 = findViewById(R.id.simpledatepicker1);
        simpledatepicker2 = findViewById(R.id.simpledatepicker2);
        btncalc = findViewById(R.id.btncalc);
        String location[] = {"Bhaktapur", "Chitwan", "Kathmandu"};
        String room[] = {"Deluxe", "AC", "Platinum"};


        ArrayAdapter adapter = new ArrayAdapter<>
                (
                        this,
                        android.R.layout.simple_list_item_1, location
                );
        ArrayAdapter adapter1 = new ArrayAdapter<>
                (
                        this,
                        android.R.layout.simple_list_item_1, room
                );
        spinlocation.setAdapter(adapter);
        spinroom.setAdapter(adapter1);
        simpledatepicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCalendar1();
            }
        });


        simpledatepicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCalendar2();

            }
        });

    }


    private void loadCalendar1() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = month + "/" + dayOfMonth + "/" + year;
                tvindate.setText(date);
            }

        }, year, month, day);
        datePickerDialog.show();
    }


    private void loadCalendar2() {
        final Calendar c1 = Calendar.getInstance();
        year1= c1.get(Calendar.YEAR);
        month1 = c1.get(Calendar.MONTH);
        day1= c1.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year1, int month1, int dayOfMonth1) {
                String date = month1 + "/" + dayOfMonth1 + "/" + year1;
                tvoutdate.setText(date);

            }
        }, year1, month1, day1);

        datePickerDialog.show();

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();

                cal1.set(year1, month1, day1);
                cal2.set(year2, month2, day2);

                long millis1 = cal1.getTimeInMillis();
                long millis2 = cal2.getTimeInMillis();

                long diff=millis2-millis1;
                long diffDays = diff / (24 * 60 * 60 * 1000);

                Toast.makeText(MainActivity.this, "is"+diff, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "First is"+year1+""+month1+""+day1, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Second IS"+year2+""+month2+""+day2, Toast.LENGTH_SHORT).show();

            }
        });

    }





}

