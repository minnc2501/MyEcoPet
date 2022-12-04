package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.PaymentAddressAdapter;
import com.group11.Models.CustomerAddress;
import com.group11.myecopet.databinding.ActivityPaymentAddressBinding;

import java.util.ArrayList;

public class Payment_Address extends AppCompatActivity {

    ActivityPaymentAddressBinding binding;
    PaymentAddressAdapter adapter;
    ArrayList<CustomerAddress> addressList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payment_address);
        binding = ActivityPaymentAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        loadData();
    }

    private void addEvents() {
        binding.btnTiepTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub activity 1
                Intent intent = new Intent(Payment_Address.this, Payment_Method.class);
                startActivity(intent);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_Address.this, Cart_Full.class);
                startActivity(intent);
            }
        });
    }
    private void loadData() {
        addressList = new ArrayList<>();
        addressList.add(new CustomerAddress("Nguyen Thi Thanh Thao",  "213/8 Đường Nguyễn Gia Trí, Phường 25, Quận Bình Thạnh, TP. HCM", "0337902072" ));
        addressList.add(new CustomerAddress("Nguyen Thu Thao",  "5A, Đường số 5, Khu phố 2, Phường Linh Trung, TP. HCM", "0388593086" ));
        adapter = new PaymentAddressAdapter(Payment_Address.this, R.layout.payment_address_list,addressList);
        binding.gvAddress.setAdapter(adapter);

    }
}