package com.example.mentor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private CardView doctorsCardView;
    private CardView newsCardView;
    private CardView appointmentsCardView;
    private CardView myProfileCardView;
    private CardView logOutCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        setUp();
    }

    private void setUp() {
        doctorsCardView = (CardView) findViewById(R.id.activity_main_doctors_cardView);
        newsCardView = (CardView) findViewById(R.id.activity_main_news_cardView);
        appointmentsCardView = (CardView) findViewById(R.id.activity_main_appointments_cardView);
        myProfileCardView = (CardView) findViewById(R.id.activity_main_myProfile_cardView);
        logOutCardView = (CardView) findViewById(R.id.activity_main_logOut_cardView);

        doctorsCardView.setOnClickListener(this);
        newsCardView.setOnClickListener(this);
        appointmentsCardView.setOnClickListener(this);
        myProfileCardView.setOnClickListener(this);
        logOutCardView.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null)
        if( mAuth.getCurrentUser() == null )
            startActivity(new Intent(this,SignInActivity.class));
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.activity_main_doctors_cardView:
                startActivity(new Intent(this, FindDoctorActivity.class));
                break;
            case R.id.activity_main_news_cardView:
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.activity_main_appointments_cardView:
                startActivity(new Intent(this, EventListActivity.class));
                break;
            case R.id.activity_main_myProfile_cardView:
                startActivity(new Intent(this, UserProfileActivity.class));
                break;
            case R.id.activity_main_logOut_cardView:
                handleLogOutButton();
                break;

        }

    }

    private void handleLogOutButton() {
        LoginManager.getInstance().logOut();        // Facebook Connection Log out
        FirebaseAuth.getInstance().signOut();       // Firebase Connection Log out
        startActivity(new Intent(this,SignInActivity.class));
        finish();
    }


}
