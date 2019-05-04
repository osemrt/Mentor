package com.example.mentor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import com.example.mentor.R;

public class CallingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView doctorNameTextView;
    private CircleImageView doctorCircularImageView;
    private ImageButton cancelImageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        setUp();

    }

    private void setUp() {
        doctorNameTextView = (TextView) findViewById(R.id.callinActivity_doctorName);
        doctorCircularImageView = (CircleImageView) findViewById(R.id.callingActivity_doctorCircularImage);
        cancelImageButton = (ImageButton) findViewById(R.id.callingActivity_cancelImageButton);

        cancelImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.callingActivity_cancelImageButton:
                onBackPressed();
                finish();
                break;

        }
    }
}
