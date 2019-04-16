package activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mentor.R;

import ui.SliderAdapter;

public class IntroActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private Button backButton;
    private LinearLayout linearLayout;
    private Button nextButton;
    private Button gettingStartedButton;

    private ImageView[] dots;
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
                startActivity(new Intent(context, CallingActivity.class));
                finish();
            }
        });
    }


    private void addDotsIndicator(int position) {
        dots = new ImageView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < 3; i++) {
            dots[i] = new ImageView(this);
            dots[i].setBackgroundResource(R.drawable.intro_gray_dot);
            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[position].setBackgroundResource(R.drawable.intro_rectangle);

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
