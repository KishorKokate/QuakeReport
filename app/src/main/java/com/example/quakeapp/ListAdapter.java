package com.example.quakeapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    private static final String LOG_TAG = ListAdapter.class.getSimpleName();

    public ListAdapter(@NonNull Context context, ArrayList<Earthquake> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquake currentModel = getItem(position);
        TextView magnitudeView = listItemView.findViewById(R.id.magnitude);
        TextView ofTextView = listItemView.findViewById(R.id.of);
        TextView cityTextView = listItemView.findViewById(R.id.place);
        TextView dateTextView = listItemView.findViewById(R.id.time);

        String originalText=currentModel.getPlace();

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentModel.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String part1;
        String part2;

        if (originalText.contains(LOCATION_SEPARATOR)){

            String[] parts = originalText.split(LOCATION_SEPARATOR);
            part1 = parts[0]+LOCATION_SEPARATOR; // 004-
            part2 = parts[1]; // 034556
        }else {
            part1=getContext().getString(R.string.near_the);
            part2=originalText;

        }
        ofTextView.setText(part1);
        magnitudeView.setText(currentModel.getMagnitude());
        cityTextView.setText(part2);
        dateTextView.setText(currentModel.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(String magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(Double.parseDouble(magnitude));
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
