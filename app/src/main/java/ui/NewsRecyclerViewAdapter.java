package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mentor.R;

import java.util.ArrayList;

import activities.NewsActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import model.NewsItem;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {


    private Context context;
    private ArrayList<NewsItem> newsItems;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsItem> newsItems) {
        this.context = context;
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_news_single_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        NewsItem newsItem = newsItems.get(position);
        holder.circleImageView.setImageResource(newsItem.getImageId());
        holder.newsHeader.setText(newsItem.getHeader());
        holder.newsSubtitle.setText(newsItem.getSubTitle());

    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private TextView newsHeader;
        private TextView newsSubtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = (CircleImageView) itemView.findViewById(R.id.news_circularImageView);
            newsHeader = (TextView) itemView.findViewById(R.id.news_title);
            newsSubtitle = (TextView) itemView.findViewById(R.id.news_subtitle);

        }
    }
}
