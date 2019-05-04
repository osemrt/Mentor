package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import com.google.android.material.snackbar.Snackbar;

public class DoctorActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView doctorCircularImage;
    private TextView doctorNameTextView;
    private TextView doctorSpecialistTextView;
    private LinearLayout photosLinearLayout;
    private LinearLayout reviewsLinearLayout;
    private LinearLayout callLinearLayout;
    private TextView aboutTextView;
    private Button bookAppointmentButton;
    private ImageButton backImageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        setUp();
        getPassedStrings(getIntent());

    }


    private void setUp() {
        doctorCircularImage = (CircleImageView) findViewById(R.id.news_circularImageView);
        doctorNameTextView = (TextView) findViewById(R.id.activity_doctor_doctorName_textView);
        doctorSpecialistTextView = (TextView) findViewById(R.id.activity_doctor_doctorSpecialist_textView);
        photosLinearLayout = (LinearLayout) findViewById(R.id.activity_doctor_photosLinearLayout);
        reviewsLinearLayout = (LinearLayout) findViewById(R.id.activity_doctor_reviewsLinearLayout);
        callLinearLayout = (LinearLayout) findViewById(R.id.activity_doctor_callLinearLayout);
        aboutTextView = (TextView) findViewById(R.id.activity_doctor_doctorAbout_textView);
        bookAppointmentButton = (Button) findViewById(R.id.activity_doctor_bookAppointmentButton);
        backImageButton = (ImageButton) findViewById(R.id.activity_doctor_backImageButton);

        photosLinearLayout.setOnClickListener(this);
        reviewsLinearLayout.setOnClickListener(this);
        callLinearLayout.setOnClickListener(this);
        bookAppointmentButton.setOnClickListener(this);
        backImageButton.setOnClickListener(this);
    }

    private void getPassedStrings(Intent intent) {
        doctorNameTextView.setText(intent.getStringExtra("doctorName"));
        doctorSpecialistTextView.setText(intent.getStringExtra("doctorSpecialist"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.activity_doctor_photosLinearLayout:
                if (!handlePhotos())
                    Snackbar.make(v, R.string.error_message, Snackbar.LENGTH_LONG).show();
                break;

            case R.id.activity_doctor_reviewsLinearLayout:
                startActivity(new Intent(this, ReviewActivity.class));
                break;

            case R.id.activity_doctor_callLinearLayout:
                startActivity(new Intent(this, CallingActivity.class));
                break;

            case R.id.activity_doctor_bookAppointmentButton:
                startActivity(new Intent(this, BookAppointmentCalenderActivity.class));


            case R.id.activity_doctor_backImageButton:
                onBackPressed();
                break;


        }
    }

    private boolean handlePhotos() {
        //TODO: The user wants to see the doctor photos!
        return false;
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
