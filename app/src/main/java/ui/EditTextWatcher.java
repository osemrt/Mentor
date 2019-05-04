package ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class EditTextWatcher implements TextWatcher {
    private EditText editText;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private String fieldName;

    public EditTextWatcher(EditText editText, String fieldName, String uid){
        this.editText = editText;
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("users").child(uid).child(fieldName);
        this.fieldName = fieldName;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        switch ( fieldName ){
            case "age":
                intUpload();
                break;
            case "prioritized_name":
            case "name":
            case "surname":
                StringUpload();
                break;
        }

    }

    private void StringUpload() {
        databaseReference.setValue( editText.getText().toString() );
    }

    private void intUpload() {
        int age;
        try{
            age = Integer.valueOf(editText.getText().toString());
            databaseReference.setValue(age);
        }catch ( NumberFormatException | NullPointerException e){
            e.printStackTrace();  
        }
    }
}
