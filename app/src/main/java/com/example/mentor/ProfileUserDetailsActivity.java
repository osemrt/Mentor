package com.example.mentor;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import model.Blood;
import model.Gender;
import model.SpinnerItem;
import ui.EditTextWatcher;
import ui.UserDetailsSpinnerAdapter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProfileUserDetailsActivity extends AppCompatActivity {

    // Firebase Database
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    // Image Upload
    private Uri profile_photo_path;
    private static final int PICK_IMAGE_REQUEST = 21;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    // Authentication
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    // XML
    private ImageView profile_photo;
    private EditText prioritized_name;
    private EditText age;
    private Spinner gender;
    private Spinner blood;
    private EditText name;
    private EditText surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_details);
        setup();
    }

    public void setup() {
        // Authentication Setup
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        // Database Setup
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("users").child(currentUser.getUid());

        // Image Upload Setup
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        profile_photo = findViewById(R.id.user_details_photo_view);
        profile_photo.setOnClickListener(v -> chooseImage());

        // EditText Setup
        prioritized_name = findViewById(R.id.user_details_prioritized_name);
        age = findViewById(R.id.user_details_age);
        name = findViewById(R.id.user_details_name);
        surname = findViewById(R.id.user_details_surname);

        // EditText Initial Values
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,Object> content = (HashMap<String,Object>)dataSnapshot.getValue();
                initFields(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Add Listeners to EditTexts
        prioritized_name.addTextChangedListener(new EditTextWatcher(prioritized_name, "prioritized_name", currentUser.getUid()));
        age.addTextChangedListener(new EditTextWatcher(age, "age", currentUser.getUid()));
        name.addTextChangedListener(new EditTextWatcher(name, "name", currentUser.getUid()));
        surname.addTextChangedListener(new EditTextWatcher(surname, "surname", currentUser.getUid()));

        // Setup Spinners
        spinnerSetup();


    }

    private void initFields(Map<String, Object> content) {
        if( content == null )
            Snackbar.make( prioritized_name , "No Internet Connection", Snackbar.LENGTH_LONG).show();
        else
            for(Map.Entry<String,Object> entries : content.entrySet() )
                switch (entries.getKey()){
                    case "age":
                        String text = entries.getValue().toString();
                        if( !age.hasWindowFocus() )
                            age.setText(text);
                        break;
                    case "name":
                        if( !name.hasWindowFocus() )
                            name.setText((String)entries.getValue());
                        break;
                    case "surname":
                        if( !surname.hasWindowFocus() )
                            surname.setText((String)entries.getValue());
                        break;
                    case "prioritized_name":
                        if( !prioritized_name.hasWindowFocus() )
                            prioritized_name.setText((String)entries.getValue());
                        break;
                    case "blood":
                        blood.setSelection( Blood.bloodFactory( Integer.valueOf(entries.getValue().toString()) ).getIntValue() );
                        break;
                    case "gender":
                        gender.setSelection( Gender.genderFactory( Integer.valueOf(entries.getValue().toString()) ).getIntValue() );
                        break;
                }
    }


    public void spinnerSetup(){
        blood = findViewById(R.id.user_details_blood_spinner);
        gender = findViewById(R.id.user_details_gender_spinner);

        ArrayList<SpinnerItem> bloodTypes = new ArrayList<>();
        ArrayList<SpinnerItem> genderTypes = new ArrayList<>();

        for(String s : getResources().getStringArray(R.array.user_details_blood_array) )
            bloodTypes.add( new SpinnerItem(s));

        for(String s : getResources().getStringArray(R.array.user_details_gender_array))
            genderTypes.add( new SpinnerItem(s));

        blood.setAdapter(new UserDetailsSpinnerAdapter(this, bloodTypes));
        gender.setAdapter(new UserDetailsSpinnerAdapter(this, genderTypes));

        blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                databaseReference.child("blood").setValue( Blood.bloodFactory(((SpinnerItem)parent.getItemAtPosition(position)).getTitle()).getIntValue() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                databaseReference.child("gender").setValue( Gender.genderFactory( ((SpinnerItem)parent.getItemAtPosition(position)).getTitle() ).getIntValue()  );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //TODO: You can later update ProgressDialog into ProgressBar <LATER>
    private void uploadImage() {
        if(profile_photo_path != null){
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();

            StorageReference ref = storageReference.child("user_photos/" + currentUser.getUid() );
            ref.putFile(profile_photo_path).addOnCompleteListener( task->{
                if( task.isSuccessful() ){
                    progressDialog.dismiss();
                    Toast.makeText(this, "Uploaded",Toast.LENGTH_LONG).show();
                }else{
                    progressDialog.dismiss();
                    Snackbar.make( profile_photo , task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }).addOnProgressListener( taskSnapshot -> {
                double progress = ( 100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                progressDialog.setMessage("Uploaded " + (int)progress + "%");
            });

        }
    }

    private void chooseImage() {
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult( Intent.createChooser(intent, "Select Picture"),PICK_IMAGE_REQUEST);
    }

    public void goProfile(View view){
        startActivity(new Intent(this,UserProfileActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null){
            profile_photo_path = data.getData();
            if( profile_photo_path != null){
                try{
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), profile_photo_path);
                    profile_photo.setImageBitmap(bitmap);
                    uploadImage();
                }catch ( IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
