package com.example.mentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import model.Blood;
import model.Gender;

public class UserProfileActivity extends AppCompatActivity{
    private TextView prioritized_name;
    private TextView account_balance;
    private TextView age;
    private TextView blood;
    private TextView gender;
    private CircleImageView profile_photo;
    private TextView name;
    private TextView surname;
    private Button update_user_details_btn;

    // Authentication
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    // Storage
    private FirebaseStorage storage;
    private StorageReference storageReference;

    // Database
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setup();
    }
    //TODO: Broken database connection, refactor
    public void setup(){
        // Authentication
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        // Storage
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        // Database
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("users").child(currentUser.getUid());

        // View initializations
        prioritized_name = findViewById(R.id.profile_prioritized_name);
        account_balance = findViewById(R.id.profile_balance);
        age = findViewById(R.id.profile_age);
        blood = findViewById(R.id.profile_blood);
        gender = findViewById(R.id.profile_gender);
        profile_photo = findViewById(R.id.profile_photo_view);
        name = findViewById(R.id.profile_name);
        surname = findViewById(R.id.profile_surname);
        update_user_details_btn = findViewById(R.id.profile_update_btn);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,Object> content = (HashMap<String,Object>)dataSnapshot.getValue();
                updateFields(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Profile Photo
        StorageReference photoRef = storageReference.child("user_photos/" + currentUser.getUid());
        photoRef.getDownloadUrl().addOnCompleteListener( task ->{
            if( task.isSuccessful() )
                Picasso.get().load(task.getResult()).into(profile_photo);
            else{
                Picasso.get().load(R.drawable.test_doctor_1).into(profile_photo);
            }
        });

    }

    private void updateFields(Map<String, Object> content) {
        if( content == null )
            Snackbar.make( prioritized_name , "No Internet Connection", Snackbar.LENGTH_LONG).show();
        else
            for(Map.Entry<String,Object> entries : content.entrySet() )
                switch (entries.getKey()){
                    case "age":
                        String text = entries.getValue().toString();
                        age.setText(text);
                        break;
                    case "name":
                        name.setText((String)entries.getValue());
                        break;
                    case "surname":
                        surname.setText((String)entries.getValue());
                        break;
                    case "prioritized_name":
                        prioritized_name.setText((String)entries.getValue());
                        break;
                    case "blood":
                        text = Blood.bloodFactory( Integer.valueOf(entries.getValue().toString()) ).toString();
                        blood.setText( text );
                        break;
                    case "gender":
                        text = Gender.genderFactory( Integer.valueOf(entries.getValue().toString()) ).toString();
                        gender.setText( text );
                        break;
                }

    }


    public void goHome(View v){
        startActivity( new Intent(this, MainActivity.class));
    }

    public void goUserDetails(View v){
        startActivity( new Intent(this, ProfileUserDetailsActivity.class));
    }

    public void goBack(View v){
        super.onBackPressed();
    }

    //TODO: <Later> Require email verification, take a look at here : https://firebase.googleblog.com/2017/02/email-verification-in-firebase-auth.html
    //TODO: <Later> After completing required information, convert anonymous account to normal account : https://firebase.google.com/docs/auth/android/anonymous-auth?authuser=2
    //TODO: <Later> Put additional delete account button but first authenticate from email : https://firebase.google.com/docs/auth/android/manage-users#send_a_password_reset_email
}
