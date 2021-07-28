package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class powerButtonActivity extends AppCompatActivity {
    Button stopbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_button);

        stopbtn=(Button) findViewById(R.id.sbtn);

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Motor");
                myRef.setValue(0);
                Intent intent= new Intent(powerButtonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    }
