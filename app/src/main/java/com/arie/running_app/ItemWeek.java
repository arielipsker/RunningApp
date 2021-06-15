package com.arie.running_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ItemWeek extends ArrayAdapter<Week> {

    Context context;
    List<Week> objects;

    public ItemWeek(Context context, int resource, int textViewResourceId, List<Week> objects) {
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_program,parent,false);

        TextView tvWeek = (TextView)view.findViewById(R.id.tvWeek);
        TextView tvMonday = (TextView)view.findViewById(R.id.tvMonday);
        TextView tvWednesday = (TextView)view.findViewById(R.id.tvWednesday);
        TextView tvFriday = (TextView)view.findViewById(R.id.tvFriday);
        Week week = objects.get(position);

        tvWeek.setText(week.getWeek());
        tvMonday.setText(week.getMonday());
        tvWednesday.setText(week.getWednesday());
        tvFriday.setText(week.getFriday());

        return view;
    }
}
