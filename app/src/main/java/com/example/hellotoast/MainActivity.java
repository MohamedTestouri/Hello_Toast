package com.example.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView numberCount;
    private TextView namePerson;
    private Button countButton;
    private Button toastButton;
    private Button sendButton;
  //  private Button snrButton;
    private String value="a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CHECK_ACTIVITY", "onCreate");
        setContentView(R.layout.activity_main);
        numberCount = findViewById(R.id.numberCount);
        namePerson = findViewById(R.id.namePerson);
        countButton = findViewById(R.id.count);
        toastButton = findViewById(R.id.toast);
        sendButton = findViewById(R.id.send);
      //  snrButton = findViewById(R.id.snr);
        countButton.setOnClickListener(l -> count());
        toastButton.setOnClickListener(l -> navigate());
        sendButton.setOnClickListener(l -> send());
//        snrButton.setOnClickListener(l -> {});

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CHECK_ACTIVITY", "onStart: "+value);
       // value = getIntent().getExtras().getString("namePerson");

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            if(data != null) {
                 namePerson.setText(data.getStringExtra("namePerson"));
            }
        }
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CHECK_ACTIVITY", "onResume:"+value);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CHECK_ACTIVITY", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CHECK_ACTIVITY", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CHECK_ACTIVITY", "onDestroy");
    }*/

    private void send() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("CountedNumber", numberCount.getText().toString());
        startActivity(intent);
    }

    private void navigate() {
        Toast.makeText(MainActivity.this, "You clicked: " + numberCount.getText().toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivityForResult(intent, RESULT_OK);
    }

    private void count() {
        int numberCounting = Integer.parseInt(numberCount.getText().toString());
        numberCounting += 1;
        numberCount.setText(String.valueOf(numberCounting));
    }
}