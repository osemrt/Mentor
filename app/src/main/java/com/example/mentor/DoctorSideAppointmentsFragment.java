package com.example.mentor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.RecyclerViewAppointmentItem;
import ui.DoctorSideAppointmentsRecyclerViewAdapter;

public class DoctorSideAppointmentsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerViewAppointmentItem> recyclerViewItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doctor_side_appointments, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUp();
        setAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }


    private void setAdapter() {
        //TODO: Needed the database connection!
        //Test entries
        String[] names = getResources().getStringArray(R.array.test_array_doctor_names);
        String[] date = getResources().getStringArray(R.array.test_array_appointment_date);
        String[] time = getResources().getStringArray(R.array.test_array_appointment_time);
        int[] images = {R.drawable.test_doctor_1, R.drawable.test_doctor_2, R.drawable.test_doctor_3, R.drawable.test_doctor_4, R.drawable.test_doctor_5, R.drawable.test_doctor_6};

        for (int i = 0; i < 6; i++) {
            recyclerViewItems.add(new RecyclerViewAppointmentItem(images[i], names[i], date[i], time[i]));
        }

        recyclerView.setAdapter(new DoctorSideAppointmentsRecyclerViewAdapter(getContext(), recyclerViewItems));

    }

    private void setUp() {
        recyclerViewItems = new ArrayList<>();
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.doctorSide_appointmentsFragment_recyclerView);
    }

}
