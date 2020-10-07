package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView numberCount;
private Button countButton;
private Button toastButton;
private Button sendButton;
private Button snrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberCount= findViewById(R.id.numberCount);
       countButton= findViewById(R.id.count);
       toastButton = findViewById(R.id.toast);
       sendButton = findViewById(R.id.send);
       snrButton  = findViewById(R.id.snr);
       countButton.setOnClickListener(l -> count()        );
       toastButton.setOnClickListener(l-> toast());
       sendButton.setOnClickListener(l -> send());
    }

    private void send() {
       Intent intent = new Intent(MainActivity.this, SecondActivity.class);
       intent.putExtra("CountedNumber", numberCount.getText().toString());
       startActivity(intent);
    }

    private void toast() {
        Toast.makeText(MainActivity.this, "You clicked: "+numberCount.getText().toString(), Toast.LENGTH_LONG).show();
    }

    private void count() {
        int numberCounting= Integer.parseInt(numberCount.getText().toString());
        numberCounting+=1;
        numberCount.setText(String.valueOf(numberCounting));
    }
}