package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button homeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        setUp();

    }

    private void setUp() {
        homeButton = (Button) findViewById(R.id.appointmentDetails_homeButton);
        homeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, MainActivity.class));

    }
}
