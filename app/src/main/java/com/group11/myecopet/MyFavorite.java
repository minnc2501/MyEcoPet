package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.group11.myecopet.databinding.ActivityMyFavoriteBinding;

public class MyFavorite extends AppCompatActivity {

    ActivityMyFavoriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_favorite);

        binding = ActivityMyFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menuBar.setSelectedItemId(R.id.my_favorite);
        binding.menuBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainScreen.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.my_favorite:
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
                        startActivity(new Intent(getApplicationContext(), Setting_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        addEvents();

    }
    private void addEvents() {

        binding.btnThemVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFavorite.this, MyVideos.class);
                startActivity(intent);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyFavorite.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }
    }