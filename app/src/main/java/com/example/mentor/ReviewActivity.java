package com.example.mentor;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mentor.R;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.RecyclerViewItem2;
import ui.ReviewRecyclerViewAdapter;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ImageButton backImageButton;
    private TextView doctorNameTextView;
    private TextView doctorSpecialistTextView;

    private ArrayList<RecyclerViewItem2> recyclerViewItem2s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        setUp();
        setAdapter();


    }

    private void setUp() {
        recyclerView = (RecyclerView) findViewById(R.id.review_recyclerView);
        backImageButton = (ImageButton) findViewById(R.id.activityReview_backButton);
        doctorNameTextView = (TextView) findViewById(R.id.activityReview_doctorNameTextView);
        doctorSpecialistTextView = (TextView) findViewById(R.id.activityReview_doctorSpecialistTextView);

        recyclerViewItem2s = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backImageButton.setOnClickListener(this);

    }

    private void setAdapter() {
        //TODO: Needed the database connection!
        //Test entries
        String[] users = getResources().getStringArray(R.array.test_array_users);
        String[] dates = getResources().getStringArray(R.array.test_array_review_date);
        String[] reviews = getResources().getStringArray(R.array.test_array_user_review);

        for (int i = 0; i < 10; i++)
            recyclerViewItem2s.add(new RecyclerViewItem2(users[i], reviews[i], dates[i]));


        recyclerView.setAdapter(new ReviewRecyclerViewAdapter(this, recyclerViewItem2s));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activityReview_backButton:
                onBackPressed();
                break;
        }
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
