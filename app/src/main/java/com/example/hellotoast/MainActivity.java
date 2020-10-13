package com.example.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    private Button snrButton;
    private String value = "a";

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
        snrButton = findViewById(R.id.snr);
        countButton.setOnClickListener(l -> count());
        toastButton.setOnClickListener(l -> navigate());
        sendButton.setOnClickListener(l -> send());
        snrButton.setOnClickListener( l ->{});
           /* value = getIntent().getExtras().getString("namePerson");
            namePerson.setText(value);*/


//        String ab = getIntent().getExtras().getString("namePerson");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
                if (resultCode == RESULT_OK) {
                    value = data.getStringExtra("namePerson");
                    // TODO Update your TextView.
                    namePerson.setText(value);
                    Log.d("RETURN", "Value: "+value);

            }
        }
    }


@Override
    protected void onStart() {
        super.onStart();

        Log.d("CHECK_ACTIVITY", "onStart: "+value);
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
        startActivityForResult(intent, 1);
    }

    private void navigate() {
        Toast.makeText(MainActivity.this, "You clicked: " + numberCount.getText().toString(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }

    private void count() {
        int numberCounting = Integer.parseInt(numberCount.getText().toString());
        numberCounting += 1;
        numberCount.setText(String.valueOf(numberCounting));
    }
}