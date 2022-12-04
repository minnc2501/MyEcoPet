package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityChinhsachbaomatBinding;

public class chinhsachbaomat extends AppCompatActivity {

    ActivityChinhsachbaomatBinding binding;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_chinhsachbaomat);

        binding = ActivityChinhsachbaomatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        caidatriengtu();
        quaylai();
    }

    private void quaylai() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chinhsachbaomat.this,
                        MainActivity.class);

                startActivity(intent);
            }
        });
    }

    private void caidatriengtu() {
        binding.imvCaiDatRiengTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chinhsachbaomat.this, caidatriengtu.class);
                startActivity(intent);
            }
        });
    }
}