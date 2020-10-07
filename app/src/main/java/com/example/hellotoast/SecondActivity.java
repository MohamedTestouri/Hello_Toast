package com.example.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView numberCounted;
    private EditText namePerson;
    private Button snrButton;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CHECK_ACTIVITY2", "onCreate");
        setContentView(R.layout.activity_second);
        numberCounted = findViewById(R.id.resultCount);
        namePerson = findViewById(R.id.namePerson);
        snrButton = findViewById(R.id.snr);
        String number = getIntent().getExtras().getString("CountedNumber");
        numberCounted.setText("You counted to: " + number);
        snrButton.setOnClickListener(l -> {Intent intent=new Intent();
            intent.putExtra("namePerson",namePerson.getText().toString());
            setResult(RESULT_OK, intent);
            finish();});
    }

    /* @Override
     protected void onStart() {
         super.onStart();
         Log.d("CHECK_ACTIVITY2", "onStart");
     }
*/
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CHECK_ACTIVITY2", "onResume");
        a = namePerson.getText().toString();
    }

    /*
         @Override
         protected void onPause() {
             super.onPause();
             Log.d("CHECK_ACTIVITY2", "onStop");
         }

         @Override
         protected void onDestroy() {
             super.onDestroy();
             Log.d("CHECK_ACTIVITY2", "onDestroy");
         }*/
    @Override
    protected void onStop() {
        Log.d("CHECK_ACTIVITY2", "onPause: " + a);
        Intent intent = new Intent();

        intent.putExtra("namePerson", a);
        setResult(RESULT_OK, intent);
        finish();
        super.onStop();
    }
}