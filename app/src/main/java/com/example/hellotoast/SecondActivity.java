package com.example.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView numberCounted;
    private EditText namePerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        numberCounted = findViewById(R.id.resultCount);
        namePerson = findViewById(R.id.namePerson);
        String number = getIntent().getExtras().getString("CountedNumber");
        numberCounted.setText("You counted to: " + number);
    }
}