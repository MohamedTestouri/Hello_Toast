package com.example.hellotoast;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView numberCounted;
    private TextView test;
    private EditText namePerson;
    private Button snrButton;
    private String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("CHECK_ACTIVITY2", "onCreate: " + a);
        setContentView(R.layout.activity_second);
        numberCounted = findViewById(R.id.resultCount);
        namePerson = findViewById(R.id.namePerson);
        test = findViewById(R.id.textView);
        String number = getIntent().getExtras().getString("CountedNumber");
        numberCounted.setText("You counted to: " + number);
        namePerson.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                a = namePerson.getText().toString();
                Log.d("CHECK_ACTIVITY_AA", "" + a);
                test.setText(a);
            }
        });

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
        a = namePerson.getText().toString();
        Log.d("CHECK_ACTIVITY2", "onResume: " + a);
    }

    public void navBack() {
        Intent intent = new Intent();
        intent.putExtra("namePerson", a);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CHECK_ACTIVITY2", "onPause: " + a);
        navBack();

    }

    /*
             @Override
             protected void onDestroy() {
                 super.onDestroy();
                 Log.d("CHECK_ACTIVITY2", "onDestroy");
             }*/
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CHECK_ACTIVITY2", "onStop: " + a);

    }
}