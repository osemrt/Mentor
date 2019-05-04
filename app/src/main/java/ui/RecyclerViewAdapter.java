package ui;

import android.content.Context;

import com.example.mentor.DoctorActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        viewHolder.doctorCircularImageView.setImageResource(recyclerViewItem.getImageId());
        viewHolder.doctorNameTextView.setText(recyclerViewItem.getDoctorName());
        viewHolder.doctorSpecialistTextView.setText(recyclerViewItem.getSpecialist());
        viewHolder.doctorCostTextView.setText(Float.toString(recyclerViewItem.getCost()));


    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CircleImageView doctorCircularImageView;
        private TextView doctorNameTextView;
        private TextView doctorSpecialistTextView;
        private TextView doctorCostTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            doctorCircularImageView = (CircleImageView) itemView.findViewById(R.id.doctor_list_item_imageView);
            doctorNameTextView = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorName);
            doctorSpecialistTextView = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorSpecialist);
            doctorCostTextView = (TextView) itemView.findViewById(R.id.doctor_list_item_doctorCost);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DoctorActivity.class);
            //TODO: will be passed ImageView!
            //intent.putExtra("doctorImageId", getAdapterPosition());
            intent.putExtra("doctorName", doctorNameTextView.getText().toString());
            intent.putExtra("doctorSpecialist", doctorSpecialistTextView.getText().toString());
            intent.putExtra("doctorCost", doctorCostTextView.getText().toString());
            context.startActivity(intent);

        }
    }
}
