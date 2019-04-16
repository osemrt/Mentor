package activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;

import com.example.mentor.R;

import java.util.ArrayList;

import model.SpinnerItem;
import ui.SpinnerAdapter;

public class FindDoctorActivity extends AppCompatActivity {


    private Spinner specialistSpinner;
    private Spinner dateSpinner;
    private Spinner genderSpinner;

    private ArrayList<SpinnerItem> specialists;
    private ArrayList<SpinnerItem> genders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        specialistSpinner = (Spinner) findViewById(R.id.findDoctor_specialist_spinner);
        genderSpinner = (Spinner) findViewById(R.id.findDoctor_gender_spinner);

        specialists = new ArrayList<>();
        genders = new ArrayList<>();

        String[] specialists = getResources().getStringArray(R.array.specialists);
        for (String string : specialists)
            this.specialists.add(new SpinnerItem(string));

        String[] genders = getResources().getStringArray(R.array.genders);
        for (String string : genders)
            this.genders.add(new SpinnerItem(string));

        specialistSpinner.setAdapter(new SpinnerAdapter(this, this.specialists));
        genderSpinner.setAdapter(new SpinnerAdapter(this, this.genders));

    }
}
