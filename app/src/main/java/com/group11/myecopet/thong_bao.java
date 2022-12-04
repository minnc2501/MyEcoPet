package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityThongBaoBinding;

public class thong_bao extends AppCompatActivity {

    ActivityThongBaoBinding binding;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thong_bao);

        binding = ActivityThongBaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quaylai();
    }

    private void quaylai() {

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thong_bao.this,
                        MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
