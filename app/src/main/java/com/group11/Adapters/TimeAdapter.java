package com.group11.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group11.Models.Time;
import com.group11.myecopet.R;

import java.util.List;

public class TimeAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Time> timelist;

    public TimeAdapter(Activity activity, int item_layout, List<Time> timelist) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.timelist = timelist;
    }

    @Override
    public int getCount() {
        return timelist.size();
    }

    @Override
    public Object getItem(int i) {
        return timelist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Link views
        ViewHolder holder;

        if (view == null) {
            //Link views
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(item_layout,null);

            holder.txtTime = view.findViewById(R.id.txt_Time);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        //Binding data
        Time b= timelist.get(i);
        holder.txtTime.setText(b.getTime());

        return view;
    }
    public static class ViewHolder {
        TextView txtTime;
    }
}