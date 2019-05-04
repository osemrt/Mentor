package com.example.mentor;

import android.os.Bundle;
import android.view.View;

import com.example.mentor.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewsPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_preview);
    }

    public void goBack(View v){
        super.onBackPressed();
    }
}
