package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView numberCounted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        numberCounted = findViewById(R.id.resultCount);
        String number = getIntent().getExtras().getString("CountedNumber");
        numberCounted.setText("You counted to: "+number);
    }
}