package ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentor.R;

public class SliderAdapter extends PagerAdapter {

    private Context context;
    private int[] images = {R.drawable.intro_slider_img_1, R.drawable.intro_slider_img_2, R.drawable.intro_slider_img_3};

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.intro_layout_slider, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.intro_imageView);
        TextView textView1 = (TextView) view.findViewById(R.id.intro_title);
        TextView textView2 = (TextView) view.findViewById(R.id.intro_description);

        imageView.setImageResource(images[position]);
        textView1.setText(context.getResources().getStringArray(R.array.intro_titles)[position]);
        textView2.setText(context.getResources().getStringArray(R.array.intro_descriptions)[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
