package com.example.mentor;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class DoctorSideMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private TextView menuTitleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_side_main);

        menuTitleTextView = (TextView) findViewById(R.id.doctorSide_mainActivity_menuTitle);

        //Let's set the listener
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.doctorSide_mainActivity_bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        //Let's protect the data inside of the fragments
        if (savedInstanceState == null) {
            //Let's show the first fragment that pops up when the application starts
            //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.ic_navigation_bottom_news);
        }


    }

    //Let's enable this function to return true because if it returns a false value, there will not occur anything when you selected an item from the navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.ic_navigation_bottom_news:
                fragment = new DoctorSideNewsFragment();
                menuTitleTextView.setText(R.string.doctor_side_menuTitle_news);
                break;
            case R.id.ic_navigation_bottom_appointments:
                fragment = new DoctorSideAppointmentsFragment();
                menuTitleTextView.setText(R.string.doctor_side_menuTitle_appointments);
                break;
            case R.id.ic_navigation_bottom_profile:
                fragment = new DoctorSideProfileFragment();
                menuTitleTextView.setText(R.string.doctor_side_menuTitle_profile);
                break;
            default:
                fragment = null;
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.doctorSide_mainActivity_frameLayout, fragment).commit();
        //if it returns false, you can still the fragment you want to see, but the navigation button was not be selected!
        return true;
    }
}
