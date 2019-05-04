package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mentor.R;

import java.util.ArrayList;

import model.SpinnerItem;

public class UserDetailsSpinnerAdapter extends ArrayAdapter <SpinnerItem> {
    public UserDetailsSpinnerAdapter(Context context, ArrayList<SpinnerItem> spinnerItems) {
        super(context, 0, spinnerItems);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_user_details_spinner_item, parent, false);


        TextView textView = convertView.findViewById(R.id.spinner_textView);
        SpinnerItem spinnerItem = getItem(position);

        if (spinnerItem != null)
            textView.setText(spinnerItem.getTitle());

        return convertView;

    }



}

