package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mentor.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_appointment);
    }

    public void showAppointmentDetails(View v){
        startActivity( new Intent(this, AppointmentDetailsActivity.class));
    }

    public void goBack(View v){
        super.onBackPressed();
    }

}

//TODO: Check whether the user is anonymous and require strict login to take new appointment
