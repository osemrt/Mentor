package ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mentor.CallingActivity;
import com.example.mentor.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import model.RecyclerViewAppointmentItem;

public class DoctorSideAppointmentsRecyclerViewAdapter extends RecyclerView.Adapter<DoctorSideAppointmentsRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RecyclerViewAppointmentItem> recyclerViewItems;

    public DoctorSideAppointmentsRecyclerViewAdapter(Context context, ArrayList<RecyclerViewAppointmentItem> recyclerViewItems) {
        this.context = context;
        this.recyclerViewItems = recyclerViewItems;
    }


    @NonNull
    @Override
    public DoctorSideAppointmentsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_list_row_doctorside_appointments, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorSideAppointmentsRecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewAppointmentItem recyclerViewItem = recyclerViewItems.get(position);

        holder.circularImageView.setImageResource(recyclerViewItem.getImageId());
        holder.nameTextView.setText(recyclerViewItem.getName());
        holder.dateTextView.setText(recyclerViewItem.getDate());
        holder.timeTextView.setText(recyclerViewItem.getTime());


    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CircleImageView circularImageView;
        private final TextView nameTextView;
        private final TextView dateTextView;
        private final TextView timeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            circularImageView = (CircleImageView) itemView.findViewById(R.id.doctorSide_appointment_listRow_photo);
            nameTextView = (TextView) itemView.findViewById(R.id.doctorSide_appointment_listRow_name);
            dateTextView = (TextView) itemView.findViewById(R.id.doctorSide_appointment_listRow_appointmentDate);
            timeTextView = (TextView) itemView.findViewById(R.id.doctorSide_appointment_listRow_appointmentTime);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            //If time is okay for the appointment, then start the calling activity
            //or send the doctor to the patient profile, it is up to you!
            //TODO: Needed some calculation to related to the appointment time
            if (false) {
                Intent intent = new Intent(context, CallingActivity.class);
                //TODO: will be passed ImageView!
                //intent.putExtra("imageId", getAdapterPosition());
                intent.putExtra("name", nameTextView.getText().toString());
                intent.putExtra("date", dateTextView.getText().toString());
                intent.putExtra("time", timeTextView.getText().toString());
                context.startActivity(intent);
            } else {
                Snackbar.make(v, R.string.doctor_side_recyclerViewAppointmentItem_errorText, Snackbar.LENGTH_LONG).show();
            }

        }
    }
}
