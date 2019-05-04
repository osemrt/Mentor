package com.example.mentor;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentor.R;

import java.util.ArrayList;

import model.RecyclerViewItem;
import ui.RecyclerViewAdapter;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerViewItem> recyclerViewItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        setUp();
        setAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void setAdapter() {
        //TODO: Needed the database connection!
        //Test entries
        String[] names = getResources().getStringArray(R.array.test_array_doctor_names);
        String[] specialists = getResources().getStringArray(R.array.test_array_doctor_specialists);
        String[] costs = getResources().getStringArray(R.array.test_array_doctor_costs);
        int[] images = {R.drawable.test_doctor_1, R.drawable.test_doctor_2, R.drawable.test_doctor_3, R.drawable.test_doctor_4, R.drawable.test_doctor_5, R.drawable.test_doctor_6};

        for (int i = 0; i < 6; i++) {
            recyclerViewItems.add(new RecyclerViewItem(images[i], names[i], specialists[i], Float.valueOf(costs[i])));
        }

        recyclerView.setAdapter(new RecyclerViewAdapter(this, recyclerViewItems));

    }

    private void setUp() {
        recyclerViewItems = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.doctor_list_recyclerView);
    }
    public void goBack(View v){
        super.onBackPressed();
    }
}
