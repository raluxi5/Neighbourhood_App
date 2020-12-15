package com.example.sca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter2 extends ArrayAdapter<String> {


    private Context context;

    private ArrayList<String> uNames = new ArrayList<>();
    private ArrayList<String> uComments = new ArrayList<>();

    public ListAdapter2(Context context, ArrayList<String> uNames,ArrayList<String> uComments) {
        super(context,R.layout.custom_listview_row,uNames);
        this.uNames = uNames;
        this.uComments = uComments;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ListAdapter2.ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_listview_rowsimple, null);
            viewHolder = new ListAdapter2.ViewHolder();
            viewHolder.username = (TextView) convertView
                    .findViewById(R.id.Uname);
            viewHolder.usercomment = (TextView) convertView
                    .findViewById(R.id.Ucomment);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListAdapter2.ViewHolder) convertView.getTag();
        }
        final String temp = getItem(position);

        viewHolder.username.setText(uNames.get(position));
        viewHolder.usercomment.setText(uComments.get(position));

        return convertView;
    }

    public class ViewHolder {
        TextView username;
        TextView usercomment;
    }


}
