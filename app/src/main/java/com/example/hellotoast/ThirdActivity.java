package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
private Button browserButton;
private Button dialButton;
private Button mapButton;
private Button cameraButton;
private Button contactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        browserButton = findViewById(R.id.browser);
        dialButton = findViewById(R.id.dial);
        mapButton = findViewById(R.id.map);
        cameraButton = findViewById(R.id.camera);
        contactButton = findViewById(R.id.contact);

        browserButton.setOnClickListener(l-> launchBrowser());
        dialButton.setOnClickListener(l-> openDial());
        mapButton.setOnClickListener(l-> showMap());
        cameraButton.setOnClickListener(l-> launchCamera());
        contactButton.setOnClickListener(l-> openContact());
    }

    private void openContact() {
    }

    private void launchCamera() {
    }

    private void showMap() {
    }

    private void launchBrowser() {
    }

    private void openDial() {
    }
}