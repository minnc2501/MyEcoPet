package com.group11.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.group11.Models.CartProduct;
import com.group11.myecopet.R;

import java.util.List;

public class CartProductAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<CartProduct> cartProducts;

    public CartProductAdapter(Activity activity, int item_layout, List<CartProduct> cartProducts) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.cartProducts = cartProducts;
    }

    @Override
    public int getCount() {
        return cartProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return cartProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder;
        if (view == null) {
            //Link views
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvPhoto = view.findViewById(R.id.imv_Photo);
            holder.txtName = view.findViewById(R.id.txt_ProductName);
            holder.edtProductQuantity = view.findViewById(R.id.edt_ProductQuantity);
            holder.txtPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }

        //Binding Data
        CartProduct b = cartProducts.get(i);
        holder.imvPhoto.setImageResource(b.getPhoto());
        holder.txtName.setText(b.getName());
        holder.edtProductQuantity.setText(String.valueOf(b.getQuantity()));
        holder.txtPrice.setText(String.valueOf(b.getPrice()));

        return view;
    }

    private static class viewHolder {
        ImageView imvPhoto;
        TextView txtName, txtPrice;
        EditText edtProductQuantity;
    }
}
