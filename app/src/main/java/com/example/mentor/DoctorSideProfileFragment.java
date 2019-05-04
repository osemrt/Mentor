package com.example.mentor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorSideProfileFragment extends Fragment implements View.OnClickListener {

    private CircleImageView doctorCircleImageView;
    private TextView doctorNameTextView;
    private TextView doctorSpecialistTextView;
    private TextView doctorBalanceTextView;
    private Button doctorWithdrawButton;
    private TextView aboutDoctorTextView;
    private Button doctorUpdateInformation;
    private LinearLayout doctorReviewsLinearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor_side_profile, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setup();
    }

    private void setup() {
        doctorCircleImageView = (CircleImageView) getActivity().findViewById(R.id.doctorSide_profileFragment_doctorImage);
        doctorNameTextView = (TextView) getActivity().findViewById(R.id.doctorSide_profileFragment_doctorName);
        doctorSpecialistTextView = (TextView) getActivity().findViewById(R.id.doctorSide_profileFragment_doctorSpecialist);
        doctorBalanceTextView = (TextView) getActivity().findViewById(R.id.doctorSide_profileFragment_doctorBalance);
        doctorWithdrawButton = (Button) getActivity().findViewById(R.id.doctorSide_profileFragment_withdrawButton);
        aboutDoctorTextView = (TextView) getActivity().findViewById(R.id.doctorSide_profileFragment_aboutDoctor);
        doctorUpdateInformation = (Button) getActivity().findViewById(R.id.doctorSide_profileFragment_updateInformationButton);
        doctorReviewsLinearLayout = (LinearLayout) getActivity().findViewById(R.id.doctorSide_profileFragment_doctorReviews);

        doctorWithdrawButton.setOnClickListener(this);
        doctorUpdateInformation.setOnClickListener(this);
        doctorReviewsLinearLayout.setOnClickListener(this);


    }



    //TODO: Doctor side profile stuff!
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.doctorSide_profileFragment_withdrawButton:
                Snackbar.make(v, "Withdraw button was clicked!", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.doctorSide_profileFragment_updateInformationButton:
                Snackbar.make(v, "Update Information button was clicked!", Snackbar.LENGTH_LONG).show();
                break;
            case R.id.doctorSide_profileFragment_doctorReviews:
                Snackbar.make(v, "Reviews button was clicked!", Snackbar.LENGTH_LONG).show();
                break;


        }


    }
}
