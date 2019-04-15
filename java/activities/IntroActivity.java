package activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mentor.R;

import ui.SliderAdapter;

public class IntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private Button backButton;
    private LinearLayout linearLayout;
    private Button nextButton;
    private Button gettingStartedButton;

    private TextView[] dots;
    private int currentPage;
    private Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        setUp();
        setViewPager();
        setButtons();


    }

    private void setUp() {
        linearLayout = (LinearLayout) findViewById(R.id.intro_linearLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        backButton = (Button) findViewById(R.id.intro_back_button);
        nextButton = (Button) findViewById(R.id.intro_next_button);
        gettingStartedButton = (Button) findViewById(R.id.intro_gettingStarted_button);

        viewPager.addOnPageChangeListener(this);
        addDotsIndicator(0);

    }

    private void setViewPager() {
        viewPager.setAdapter(new SliderAdapter(this));
    }

    private void setButtons() {
        context = this;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });

        gettingStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
            }
        });
    }


    private void addDotsIndicator(int position) {
        dots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < 3; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorLightGray));
            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        } else {


        }


    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        addDotsIndicator(i);
        this.currentPage = i;

        if (i == 0) {
            backButton.setEnabled(false);
            nextButton.setEnabled(true);
            backButton.setVisibility(View.INVISIBLE);

            backButton.setText("");
            nextButton.setText(">");

        } else if (i == dots.length - 1) {

            backButton.setEnabled(false);
            nextButton.setEnabled(false);
            gettingStartedButton.setEnabled(true);
            backButton.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            gettingStartedButton.setVisibility(View.VISIBLE);


        } else {
            backButton.setEnabled(true);
            nextButton.setEnabled(true);
            gettingStartedButton.setEnabled(false);
            gettingStartedButton.setVisibility(View.INVISIBLE);
            backButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.VISIBLE);

            backButton.setText("<");
            nextButton.setText(">");

        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
