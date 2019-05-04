package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentor.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    // Authentication
    private FirebaseAuth mAuth;

//    private EditText nameEditText;
    private EditText emailEditText;
//    private EditText mobileNumberEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;
    private ImageButton backImageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        setUp();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }

    public void updateUI(FirebaseUser user){
        if(user != null){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("Uid",user.getUid());
            startActivity(intent);
            finish();
        }
    }

    private void setUp() {
//        nameEditText = (EditText) findViewById(R.id.activity_signUp_name_editText);
        emailEditText = (EditText) findViewById(R.id.activity_signUp_email_editText);
        //mobileNumberEditText = (EditText) findViewById(R.id.activity_signUp_mobileNumber_editText);
        passwordEditText = (EditText) findViewById(R.id.activity_signUp_password_editText);
        confirmPasswordEditText = (EditText) findViewById(R.id.activity_signUp_confirmPassword_editText);
        signUpButton = (Button) findViewById(R.id.activity_signUp_signUp_button);
        backImageButton=(ImageButton)findViewById(R.id.activity_signUp_back_button);

        backImageButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.activity_signUp_back_button:
                onBackPressed();
                break;
            case R.id.activity_signUp_signUp_button:
                handleSignUpButton(v);
                break;

        }
    }

    private void handleSignUpButton(View v) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        if(password.length() < 6)
            Snackbar.make(v, getString(R.string.short_password), Snackbar.LENGTH_LONG).show();
        else
            if( password.equals(confirmPassword))
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, task->{
                    if( task.isSuccessful() )
                        updateUI( mAuth.getCurrentUser() );
                    else{
                        Snackbar.make(v, task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                        updateUI(null);
                    }

                });
            else
                Snackbar.make(v, getString(R.string.password_mismatch), Snackbar.LENGTH_LONG).show();

    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
