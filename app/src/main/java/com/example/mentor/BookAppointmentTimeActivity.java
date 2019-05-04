package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookAppointmentTimeActivity extends AppCompatActivity implements View.OnClickListener {

    private TimePicker timePicker;
    private Button bookAppointmentButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment_time);

        setUp();

    }

    private void setUp() {
        timePicker = (TimePicker) findViewById(R.id.bookAppointmentTimeActivity_timePicker);
        bookAppointmentButton = (Button) findViewById(R.id.bookAppointmentTimeActivity_bookAppointmentButton);

        bookAppointmentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO: Needed the database connection!
        startActivity(new Intent(this, CreateAppointmentActivity.class));
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
