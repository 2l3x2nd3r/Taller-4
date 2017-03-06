package com.example.movil.taller_4;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by movil on 3/6/17.
 */

public class ProjectAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Project> data;

    public ProjectAdapter(Context context, ArrayList<Project> data){
        this.context = context;
        this.data = data;
    }

    public ArrayList<Project> getData() {
        return data;
    }

    public void setData(ArrayList<Project> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        String text = data.get(i).getName();

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.row, null);
        }

        TextView tv = (TextView) view.findViewById(R.id.tvRow);
        tv.setText(text);

        return view;
    }
}
