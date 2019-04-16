package ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentor.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import model.RecyclerViewItem;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private Context context;
    private ArrayList<RecyclerViewItem> recyclerViewItems;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem> recyclerViewItems) {
        this.context = context;
        this.recyclerViewItems = recyclerViewItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {

        RecyclerViewItem recyclerViewItem = recyclerViewItems.get(i);

        viewHolder.doctorImage.setImageResource(recyclerViewItem.getImageId());
        viewHolder.doctorName.setText(recyclerViewItem.getDoctorName());
        viewHolder.doctorSpecialist.setText(recyclerViewItem.getSpecialist());
        viewHolder.doctorCost.setText(Float.toString(recyclerViewItem.getCost()));
        viewHolder.costImage.setImageResource(R.drawable.cost);


    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView doctorImage;
        private TextView doctorName;
        private TextView doctorSpecialist;
        private TextView doctorCost;
        private ImageView costImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            doctorImage = (CircleImageView) itemView.findViewById(R.id.doctor_list_item_imageView);
            doctorName = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorName);
            doctorSpecialist = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorSpecialist);
            doctorCost = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorCost);
            costImage = (ImageView) itemView.findViewById(R.id.doctor_list_item_doctorCostImage);
        }
    }
}
