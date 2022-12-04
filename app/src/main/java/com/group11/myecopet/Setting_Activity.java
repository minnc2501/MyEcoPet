package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.group11.myecopet.databinding.ActivitySettingBinding;

public class Setting_Activity extends AppCompatActivity {
    ActivitySettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_setting);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menuBar.setSelectedItemId(R.id.setting);
        binding.menuBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.my_favorite:
                        startActivity(new Intent(getApplicationContext(), MyFavorite.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bag:
                        startActivity(new Intent(getApplicationContext(), Follow_Order.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.add_to_cart:
                        startActivity(new Intent(getApplicationContext(), Cart_Full.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting:
                        return true;
                }
                return false;
            }
        });

        moHoSo();
        moDonHang();
        moCaidat();
        moThongbao();
        moDiacChi();
    }

    private void moDiacChi() {
        binding.btnDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Activity.this, DiaChi.class);
                startActivity(intent);
            }
        });
    }

    private void moThongbao() {
        binding.btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Activity.this, thong_bao.class);
                startActivity(intent);
            }
        });
    }

    private void moCaidat() {
        binding.btnCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Activity.this, chinhsachbaomat.class);
                startActivity(intent);
            }
        });
    }

    private void moDonHang() {
        binding.btnDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Activity.this, xemdonhang.class);
                startActivity(intent);
            }
        });
    }

    private void moHoSo() {
        binding.btnHoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting_Activity.this,
                        Profile.class);

                startActivity(intent);
            }
        });
    }


}