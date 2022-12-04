package com.group11.Adapters;

import android.content.Context;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.group11.Models.rcmProduct;
import com.group11.myecopet.MainActivity;
import com.group11.myecopet.MainScreen;
import com.group11.myecopet.R;

import java.util.List;

public class    rcmProductAdapter extends BaseAdapter {
    MainScreen activity;
    int item_layout;
    List<rcmProduct> products;

    public rcmProductAdapter(MainScreen activity, int item_layout, List<rcmProduct> products) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }

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
        Viewholder holder = null;
        if (view == null) {
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvProductImage =view.findViewById(R.id.imv_productImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.ProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        } else {
            holder = (Viewholder) view.getTag();
        }
        //Binding data
            rcmProduct p =products.get(i);
            holder.imvProductImage.setImageResource(p.getProductImage());
            holder.txtProductName.setText(p.getProductName());
            holder.ProductPrice.setText(String.valueOf(p.getProductPrice()));

        return view;
    }

    public static  class Viewholder {
        ImageView imvProductImage;
        TextView txtProductName, ProductPrice;
    }

}
