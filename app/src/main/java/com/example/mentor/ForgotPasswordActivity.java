package com.example.mentor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentor.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth auth;

    private EditText emailEditText;
    private Button resetPasswordButton;
    private ImageButton backImageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        setUp();

    }

    private void setUp() {
        emailEditText = (EditText) findViewById(R.id.activity_forgetPass_email_editText);
        resetPasswordButton = (Button) findViewById(R.id.activity_forgetPass_resetPassword_button);
        backImageButton = (ImageButton) findViewById(R.id.activity_forgetPass_backButton);

        resetPasswordButton.setOnClickListener(this);
        backImageButton.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.activity_forgetPass_resetPassword_button:
                handleResetPasswordButton(v);
                break;
            case R.id.activity_forgetPass_backButton:
                onBackPressed();
                break;


        }
    }

    private void handleResetPasswordButton(View v) {
        String email = emailEditText.getText().toString();
        auth.sendPasswordResetEmail(email).addOnCompleteListener( task->{
            if( task.isSuccessful() )
                Snackbar.make(v, getString(R.string.email_reset_message), Snackbar.LENGTH_LONG).show();
            else
                Snackbar.make(v,task.getException().getMessage(),Snackbar.LENGTH_LONG).show();
        });
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
