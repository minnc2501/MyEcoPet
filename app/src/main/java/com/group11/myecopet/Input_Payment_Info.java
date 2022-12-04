package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityInputPaymentInfoBinding;

public class Input_Payment_Info extends AppCompatActivity {

    ActivityInputPaymentInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart_full);

        binding = ActivityInputPaymentInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnThemMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub activity 1
                Intent intent = new Intent(Input_Payment_Info.this, Payment_Method.class);
                startActivity(intent);
            }
        });
    }
}