package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityDialogConfirmPhoneBinding;

public class dialogConfirmPhone extends AppCompatActivity {
    ActivityDialogConfirmPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dialog_confirm_phone);
        binding = ActivityDialogConfirmPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dialogConfirmPhone.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }

}