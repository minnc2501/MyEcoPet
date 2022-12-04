package com.group11.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group11.Models.PaymentMethod;
import com.group11.myecopet.R;

import java.util.List;

public class PaymentMethodAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<PaymentMethod> paymentMethods;

    public PaymentMethodAdapter(Activity activity, int item_layout, List<PaymentMethod> paymentMethods) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.paymentMethods = paymentMethods;
    }

    @Override
    public int getCount() {
        return paymentMethods.size();
    }

    @Override
    public Object getItem(int i) {
        return paymentMethods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder holder = null;
        if (view == null) {
            //Link views
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvCardLogo = view.findViewById(R.id.imv_CardLogo);
            holder.txtCardName = view.findViewById(R.id.txt_CardName);
            holder.txtCardId = view.findViewById(R.id.txt_CardId);

            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }

        //Binding Data
        PaymentMethod b = paymentMethods.get(i);
        holder.imvCardLogo.setImageResource(b.getCardLogo());
        holder.txtCardName.setText(b.getCardName());
        holder.txtCardId.setText(String.valueOf(b.getCardId()));

        return view;
    }
    private static class viewHolder {

        ImageView imvCardLogo;
        TextView txtCardName, txtCardId;
    }



}
