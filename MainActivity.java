package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private
    Button pbtn;
    ImageButton settingbtn;
    ImageButton wlbtn;
    ImageButton rprt;
    ImageButton grh;
    ImageButton schb;
    ImageButton bll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbtn = (Button) findViewById(R.id.powerbtn);

        settingbtn = (ImageButton) findViewById(R.id.settingButton);
        wlbtn = (ImageButton) findViewById(R.id.waterLevelbtn);
        rprt = (ImageButton) findViewById(R.id.reportButton);
        grh = (ImageButton) findViewById(R.id.graphButton);
        schb = (ImageButton) findViewById(R.id.imageButton2);
        bll = (ImageButton) findViewById(R.id.imageButton5);

        bll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, billActivity.class);
                startActivity(intent);
            }
        });
        schb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, scheduleActivity.class);
                startActivity(intent);
            }
        });
        grh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, graphActivity.class);
                startActivity(intent);
            }
        });
        rprt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, reportActivity.class);
                startActivity(intent);
            }
        });
        wlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, waterLevelActivity.class);
                startActivity(intent);
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, settingActivity.class);
                startActivity(intent);
            }
        });
        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Motor");
                myRef.setValue(1);
                Intent intent = new Intent(MainActivity.this, powerButtonActivity.class);
                startActivity(intent);
            }
        });

    }
}



