package com.example.sca;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.hsalf.smilerating.SmileRating;
import com.hsalf.smileyrating.SmileyRating;

import java.util.ArrayList;

public class ListAdapter3 extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> featuresName = new ArrayList<String>();


    public ListAdapter3(Context context, ArrayList<String> featuresName) {
        super(context,R.layout.custom_listview_row2,featuresName);
        this.context = context;
        this.featuresName = featuresName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ListAdapter3.ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_listview_row2, null);
            viewHolder = new ListAdapter3.ViewHolder();

            viewHolder.name = (TextView) convertView
                    .findViewById(R.id.charact_name);
            viewHolder.imag = (ImageView) convertView
                    .findViewById(R.id.imageView);
            viewHolder.sentiment =  convertView
                    .findViewById(R.id.ratingBar);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListAdapter3.ViewHolder) convertView.getTag();
        }

        final String temp = getItem(position);
        viewHolder.name.setText(featuresName.get(position));

        switch (position){
            case 0:
                viewHolder.imag.setImageResource(R.drawable.painting_palette);
                break;
            case 1:
                viewHolder.imag.setImageResource(R.drawable.shopping_bag);
                break;
            case 2:
                viewHolder.imag.setImageResource(R.drawable.hotel);
                break;
            case 3:
                viewHolder.imag.setImageResource(R.drawable.hospital);
                break;
        }


        viewHolder.sentiment.setNumStars(5);

        return convertView;
    }

    public class ViewHolder {
        TextView name;
        ImageView imag;
        //SmileRating sentiment;
        RatingBar sentiment;
    }








}
