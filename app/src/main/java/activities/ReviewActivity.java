package activities;

import android.os.Bundle;

import com.example.mentor.R;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.RecyclerViewItem2;
import ui.ReviewRecyclerViewAdapter;

public class ReviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerViewItem2> recyclerViewItem2s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        recyclerViewItem2s = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.review_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] users = getResources().getStringArray(R.array.test_array_users);
        String[] dates = getResources().getStringArray(R.array.test_array_review_date);
        String[] reviews = getResources().getStringArray(R.array.test_array_user_review);

        for (int i = 0; i < 10; i++)
            recyclerViewItem2s.add(new RecyclerViewItem2(users[i], reviews[i], dates[i]));


        recyclerView.setAdapter(new ReviewRecyclerViewAdapter(this, recyclerViewItem2s));
    }
}
