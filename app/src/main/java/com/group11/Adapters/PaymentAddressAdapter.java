package com.group11.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group11.Models.CustomerAddress;
import com.group11.myecopet.R;

import java.util.List;

public class PaymentAddressAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<CustomerAddress> customerAddresses;

    public PaymentAddressAdapter(Activity activity, int item_layout, List<CustomerAddress> customerAddresses) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.customerAddresses = customerAddresses;
    }

    @Override
    public int getCount() {
        return customerAddresses.size();
    }

    @Override
    public Object getItem(int i) {
        return customerAddresses.get(i);
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

            holder.txtCustName = view.findViewById(R.id.txt_CustName);
            holder.txtCustAddress = view.findViewById(R.id.txt_CustAddress);
            holder.txtCustPhone = view.findViewById(R.id.txt_CustPhone);

            view.setTag(holder);
        } else {
            holder = (viewHolder) view.getTag();
        }

        //Binding Data
        CustomerAddress b = customerAddresses.get(i);
        holder.txtCustName.setText(b.getCustName());
        holder.txtCustAddress.setText(String.valueOf(b.getCustAddress()));
        holder.txtCustPhone.setText(String.valueOf(b.getCustPhone()));

        return view;
    }

    private static class viewHolder {

        TextView txtCustName, txtCustAddress, txtCustPhone;
    }
}
