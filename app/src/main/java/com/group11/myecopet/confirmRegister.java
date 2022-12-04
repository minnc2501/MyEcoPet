package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityConfirmRegisterBinding;

public class confirmRegister extends AppCompatActivity {

    ActivityConfirmRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_confirm_register);
        binding = ActivityConfirmRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

    }

    private void addEvents() {
        binding.btnConfirmPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show Custom Dialog
                Dialog dialog = new Dialog(confirmRegister.this);
                dialog.setContentView(R.layout.activity_dialog_confirm_phone);


                Button exit = dialog.findViewById(R.id.btn_OK);
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(confirmRegister.this, MainScreen.class);
                        startActivity(intent);
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }

}