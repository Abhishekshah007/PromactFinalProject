package com.example.promactfinalassessmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowUsers extends AppCompatActivity {
    private TextView responseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        responseTextView = findViewById(R.id.response_text_view);

        // Get the response string from the intent
        String response = getIntent().getStringExtra("response_data");


        // Display the response string in the TextView
        responseTextView.setText(response);
    }
}