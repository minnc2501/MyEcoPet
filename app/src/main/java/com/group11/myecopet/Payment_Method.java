package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.PaymentMethodAdapter;
import com.group11.Models.PaymentMethod;
import com.group11.myecopet.databinding.ActivityPaymentMethodBinding;

import java.util.ArrayList;

public class Payment_Method extends AppCompatActivity {

    ActivityPaymentMethodBinding binding;
    PaymentMethodAdapter adapter;
    ArrayList<PaymentMethod> methodList;

    Button buttonOpenDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payment_method);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buttonOpenDialog = findViewById(R.id.btnThemLienKet);

        buttonOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomPaymentInfo bottomPaymentInfo = new BottomPaymentInfo();
                bottomPaymentInfo.show(getSupportFragmentManager(),"TAG");
            }
        });



        addEvents();
        loadData();
    }

    private void addEvents() {
        binding.btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub activity 1
                Intent intent = new Intent(Payment_Method.this, Order_Confirm.class);
                startActivity(intent);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment_Method.this, Payment_Address.class);
                startActivity(intent);
            }
        });
    }
    private void loadData() {
        methodList = new ArrayList<>();
        methodList.add(new PaymentMethod(R.drawable.logo_visa,"Visa", "xxxx xxxx xxxx 1704"));
        methodList.add(new PaymentMethod(R.drawable.logo_master_card,"Master Card", "xxxx xxxx xxxx 1704"));

        adapter = new PaymentMethodAdapter(Payment_Method.this, R.layout.payment_method_list, methodList);
        binding.gvMethod.setAdapter(adapter);
    }


}