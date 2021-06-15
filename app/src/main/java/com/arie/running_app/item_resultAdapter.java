package com.arie.running_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class item_resultAdapter extends ArrayAdapter<lastResult> {

        Context context;
        List<lastResult> objects;

        public item_resultAdapter(Context context, int resource, int textViewResourceId, List<lastResult> objects) {
            super(context, resource, textViewResourceId, objects);

            this.context=context;
            this.objects=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.item_result,parent,false);

            TextView tvTitle = (TextView)view.findViewById(R.id.tvDate);
            TextView tvSubTitle = (TextView)view.findViewById(R.id.tvTime);

            lastResult temp = objects.get(position);

            tvTitle.setText(temp.getDate());
            tvSubTitle.setText(temp.getTime());



            return view;
        }
}
