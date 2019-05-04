package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.util.Date;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookAppointmentCalenderActivity extends AppCompatActivity implements View.OnClickListener {

    private CalendarView calendarView;
    private Button nextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment_calender);

        setUp();


    }

    private void setUp() {
        //TODO: Calender listener...
        calendarView = (CalendarView) findViewById(R.id.bookAppointmentCalenderActivity_calenderView);
        nextButton = (Button) findViewById(R.id.bookAppointmentCalenderActivity_nextButton);

        long appointmentDate = calendarView.getDate();

        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, BookAppointmentTimeActivity.class));
    }

    public void goBack(View v){
        super.onBackPressed();
    }

}
