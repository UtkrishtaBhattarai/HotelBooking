package com.example.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinlocation,spinroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinlocation=findViewById(R.id.spinlocation);
        spinroom=findViewById(R.id.spinroom);
        String location[]={"Bhaktapur","Chitwan","Kathmandu"};
        String room[]={"Deluxe","AC","Platinum"};
        ArrayAdapter adapter=new ArrayAdapter<>
                (
                        this,
                        android.R.layout.simple_list_item_1,location
                );
        ArrayAdapter adapter1=new ArrayAdapter<>
                (
                        this,
                        android.R.layout.simple_list_item_1,room
                );
        spinlocation.setAdapter(adapter);
        spinroom.setAdapter(adapter1);
    }
}
