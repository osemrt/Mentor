package activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.mentor.R;

public class FirstActivity extends AppCompatActivity {

    private ImageView imageView;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        context = getApplicationContext();

        //Let's add the fading animation to the imageView
        imageView = (ImageView) findViewById(R.id.intro_big_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.intro_fading_anim);
        imageView.startAnimation(animation);
        imageView.setVisibility(View.VISIBLE);

        //Stop the animation
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, IntroActivity.class));
                finish();
            }
        }, 5000);



    }
}
