package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mentor.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import model.RecyclerViewItem2;

public class ReviewRecyclerViewAdapter extends RecyclerView.Adapter<ReviewRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecyclerViewItem2> recyclerViewItem2s;

    public ReviewRecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem2> recyclerViewItem2s) {
        this.context = context;
        this.recyclerViewItem2s = recyclerViewItem2s;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_review_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewItem2 recyclerViewItem = recyclerViewItem2s.get(position);

        holder.name.setText(recyclerViewItem.getName());
        holder.date.setText(recyclerViewItem.getDate());
        holder.userReview.setText(recyclerViewItem.getReview());

    }

    @Override
    public int getItemCount() {
        return recyclerViewItem2s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;
        private TextView userReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.review_user_name);
            date = (TextView) itemView.findViewById(R.id.review_date);
            userReview = (TextView) itemView.findViewById(R.id.review_user_comment);


        }
    }
}
