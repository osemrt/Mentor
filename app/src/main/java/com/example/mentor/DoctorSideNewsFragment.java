package com.example.mentor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.NewsItem;
import ui.NewsRecyclerViewAdapter;

public class DoctorSideNewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<NewsItem> newsItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor_side_news, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setup();
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

        recyclerView.setAdapter(new NewsRecyclerViewAdapter(getActivity(), newsItems));

    }

    private void setup() {
        newsItems = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.doctorSide_newsFragment_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
