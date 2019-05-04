package com.example.mentor;

import android.os.Bundle;
import android.view.View;

import com.example.mentor.R;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.NewsItem;
import ui.NewsRecyclerViewAdapter;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<NewsItem> newsItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        setUp();


        setAdapter();


    }

    private void setAdapter() {
        //TODO: Needed the database connection!
        //Test entries
        int[] imageIds = {R.drawable.news_1, R.drawable.news_2, R.drawable.news_3, R.drawable.news_4,
                R.drawable.news_5, R.drawable.news_6, R.drawable.news_1, R.drawable.news_2, R.drawable.news_3,
                R.drawable.news_4, R.drawable.news_5, R.drawable.news_6};
        String[] newsHeaders = getResources().getStringArray(R.array.test_news_headers);
        String[] newsSubTitles = getResources().getStringArray(R.array.test_news_subTitle);

        for (int i = 0; i < 12; i++)
            newsItems.add(new NewsItem(imageIds[i], newsHeaders[i], newsSubTitles[i]));

        recyclerView.setAdapter(new NewsRecyclerViewAdapter(this, newsItems));

    }

    private void setUp() {
        newsItems = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.news_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
