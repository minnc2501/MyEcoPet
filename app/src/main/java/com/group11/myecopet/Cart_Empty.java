package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.group11.myecopet.databinding.ActivityCartEmptyBinding;

public class Cart_Empty extends AppCompatActivity {
    ActivityCartEmptyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart_empty);
        binding = ActivityCartEmptyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menuBar.setSelectedItemId(R.id.add_to_cart);
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
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), Setting_Activity.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });
        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart_Empty.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart_Empty.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
    }

}