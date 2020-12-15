package com.example.sca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter1 extends ArrayAdapter<String> {

    customButtonListener customListner;

    public interface customButtonListener {
        public void onButtonClickListner(int position,String value);
    }

    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }

    private Context context;

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> userPosts = new ArrayList<>();

    public ListAdapter1(Context context, ArrayList<String> usernames,ArrayList<String> userPosts) {
        super(context,R.layout.custom_listview_row,usernames);
        this.usernames = usernames;
        this.userPosts = userPosts;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_listview_row, null);
            viewHolder = new ViewHolder();
            viewHolder.USERname = (TextView) convertView
                    .findViewById(R.id.USERname);
            viewHolder.USERpost = (TextView) convertView
                    .findViewById(R.id.USERpost);
            viewHolder.commentButton = (Button) convertView
                    .findViewById(R.id.commentButton);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final String temp = getItem(position);

        viewHolder.USERname.setText(usernames.get(position));
        viewHolder.USERpost.setText(userPosts.get(position));

        viewHolder.commentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customListner != null) {
                    customListner.onButtonClickListner(position,temp);
                }

            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView USERname;
        TextView USERpost;
        Button commentButton;
    }
}
