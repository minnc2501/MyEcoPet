package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityResetPasswordBinding;

public class resetPassword extends AppCompatActivity {

    ActivityResetPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_reset_password);
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        addEvents();

    }

    private void addEvents() {
        binding.btnConfirmPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show Custom Dialog
                Dialog dialog = new Dialog(resetPassword.this);
                dialog.setContentView(R.layout.activity_dialog_reset_password);


                Button exit = dialog.findViewById(R.id.btn_OK);
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(resetPassword.this, login.class);
                        startActivity(intent);

                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }

}