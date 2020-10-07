package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

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

        browserButton.setOnClickListener(l -> openApp("Browser"));
        dialButton.setOnClickListener(l -> openApp("Contact"));
        mapButton.setOnClickListener(l -> openApp("Map"));
        cameraButton.setOnClickListener(l -> openApp("Camera"));
        contactButton.setOnClickListener(l -> openApp("Contact"));
    }

    public void openApp(String intentName) {
        Intent intent = null;
        switch (intentName) {
            case "Contact":
                intent = new Intent(Intent.ACTION_DIAL);
                break;
            case "Map":
                intent = new Intent();
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                break;
            case "Camera":
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                break;
            case "Browser":
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                break;
            default:
                Toast.makeText(ThirdActivity.this, "ERROR !", Toast.LENGTH_LONG).show();
                break;
        }
        startActivity(intent);
    }
}