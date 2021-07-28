package com.example.myapplication10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class waterLevelActivity extends AppCompatActivity {


    TextView temp;
    TextView water;
    DatabaseReference wtr;
    DatabaseReference dref;
    String wstrng;
    String tempStatus;
    String ldn="No Water";
    String ldn2="Water Dectected";
    String ldn3="Loading...";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_level);
        temp=(TextView) findViewById(R.id.textView17);
        water=(TextView) findViewById(R.id.textView18);
        wtr= FirebaseDatabase.getInstance().getReference();
        dref= FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tempStatus=snapshot.child("Temperature").getValue().toString();
                temp.setText(tempStatus);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        wtr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                wstrng=snapshot.child("WATER").getValue().toString();
                if (wstrng.equals("1"))
                    water.setText(ldn);
                else if (wstrng.equals("0"))
                    water.setText(ldn2);
                else
                    water.setText(ldn3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}