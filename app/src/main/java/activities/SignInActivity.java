package activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentor.R;
import com.google.android.material.snackbar.Snackbar;


public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText;
    private EditText passwordEditText;
    private RadioButton rememberRadioButton;
    private TextView forgetPasswordTextView;
    private Button logInButton;
    private ImageButton facebookImageButton;
    private ImageButton googlePlusImageButton;
    private TextView createAccountTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        setUp();

    }

    private void setUp() {
        emailEditText = (EditText) findViewById(R.id.activity_sign_in_email_editText);
        passwordEditText = (EditText) findViewById(R.id.activity_sign_in_password_editText);
        rememberRadioButton = (RadioButton) findViewById(R.id.activity_sign_in_remember_radioButton);
        forgetPasswordTextView = (TextView) findViewById(R.id.activity_sign_in_forget_password_textView);
        logInButton = (Button) findViewById(R.id.activity_sign_in_log_in_button);
        facebookImageButton = (ImageButton) findViewById(R.id.activity_sign_in_facebook_imageButton);
        googlePlusImageButton = (ImageButton) findViewById(R.id.activity_sign_in_google_plus_imageButton);
        createAccountTextView = (TextView) findViewById(R.id.activity_sign_in_create_account_textView);

        rememberRadioButton.setOnClickListener(this);
        logInButton.setOnClickListener(this);
        facebookImageButton.setOnClickListener(this);
        googlePlusImageButton.setOnClickListener(this);
        forgetPasswordTextView.setOnClickListener(this);
        createAccountTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.activity_sign_in_remember_radioButton:
                if (((RadioButton) v).isChecked())
                    ((RadioButton) v).setChecked(false);
                else
                    ((RadioButton) v).setChecked(true);
                break;

            case R.id.activity_sign_in_forget_password_textView:
                startActivity(new Intent(this, ForgotPasswordActivity.class));
                break;

            case R.id.activity_sign_in_log_in_button:
                if (!handleLogInButton())
                    Snackbar.make(v, R.string.msg_account_not_found, Snackbar.LENGTH_LONG).show();
                break;


        }

    }

    private boolean handleLogInButton() {
        //TODO: Login button was clicked!
        //Test
        if ("abc".equalsIgnoreCase(emailEditText.getText().toString()) && "123".equals(passwordEditText.getText().toString()))
            return true;
        else
            return false;

    }
}
