package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityCaidatriengtuBinding;

public class caidatriengtu extends AppCompatActivity {

    ActivityCaidatriengtuBinding binding;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_caidatriengtu);

        binding = ActivityCaidatriengtuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quaylai();
    }

    private void quaylai() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(caidatriengtu.this,
                        Setting_Activity.class);

                startActivity(intent);
            }
        });
    }
}