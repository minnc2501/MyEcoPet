package com.group11.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group11.Models.Product;
import com.group11.myecopet.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    public ProductAdapter(Activity activity, int item_layout, List<Product> products) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }

    Activity activity;
    int item_layout;
    List<Product> products;

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
//
            holder.txt_productName = view.findViewById(R.id.txt_productName);
            holder.txt_productPrice = view.findViewById(R.id.txt_productPrice);
            holder.imv_Product= view.findViewById(R.id.imv_Product);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Product p = products.get(i);
        holder.txt_productName.setText(p.getProductName());
        holder.txt_productPrice.setText(p.getProductPrice());
        holder.txt_productName.setText(p.getProductName());
        holder.imv_Product.setImageResource(p.getImage());

        return view;
        }

    public static class ViewHolder {
        TextView txt_productName, txt_productPrice;
        ImageView imv_Product;

    }
}
