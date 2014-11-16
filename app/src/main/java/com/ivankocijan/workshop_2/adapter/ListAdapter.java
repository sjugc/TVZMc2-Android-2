package com.ivankocijan.workshop_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ivankocijan.workshop_2.R;
import com.ivankocijan.workshop_2.model.POJO;

import java.util.ArrayList;

/**
 * Created by ivankocijan on 08.03.2014..
 */
public class ListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<POJO> objects;

    public ListAdapter (Context context, ArrayList<POJO> objects) {
        this.objects = objects;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public long getItemId (int position) {
        return 0;
    }

    @Override
    public int getCount () {
        return objects.size();
    }

    @Override
    public POJO getItem (int position) {
        return objects.get(position);
    }


    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.simple_list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) convertView.findViewById(R.id.list_item_text);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.text.setText(getItem(position).getText());

        return convertView;


    }

    private static class ViewHolder {

        private TextView text;

    }


}
