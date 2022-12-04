package com.group11.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group11.Models.diachi;
import com.group11.myecopet.DiaChi;
import com.group11.myecopet.R;

import java.util.List;

public class diachiadapter extends BaseAdapter {
    DiaChi activity;
    int diachi_layout;
    List<diachi> diachis;

    public diachiadapter(DiaChi activity, int diachi_layout, List<diachi> diachis) {
        this.activity = activity;
        this.diachi_layout = diachi_layout;
        this.diachis = diachis;
    }

    @Override
    public int getCount() {
        return diachis.size();
    }

    @Override
    public Object getItem(int i) {
        return diachis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater =
                    (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(diachi_layout, null);

            holder.txtHoTen = view.findViewById(R.id.txt_HoTen);
            holder.txtDiaChi = view.findViewById(R.id.txt_DiaChi);
            holder.txtSDT = view.findViewById(R.id.txt_SDT);
            holder.txtLoai = view.findViewById(R.id.txt_Loai);
            holder.sua = view.findViewById(R.id.imv_Sua);
            holder.xoa = view.findViewById(R.id.imv_Xoa);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        diachi p = diachis.get(i);
        holder.txtHoTen.setText(p.getHoTen());
        holder.txtDiaChi.setText(String.valueOf(p.getDiaChi()));
        holder.txtSDT.setText(String.valueOf(p.getSDT()));
        holder.txtLoai.setText(String.valueOf(p.getLoai()));
        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openDialogUpdateDiachi(p);
            }
        });
        return view;
    }

    public static class ViewHolder {
        TextView txtHoTen, txtDiaChi, txtSDT, txtLoai;
        ImageView sua, xoa;
    }
}
