package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.group11.Adapters.CartProductAdapter;
import com.group11.Models.CartProduct;
import com.group11.myecopet.databinding.ActivityCartFullBinding;

import java.util.ArrayList;

public class Cart_Full extends AppCompatActivity {

    ActivityCartFullBinding binding;
    CartProductAdapter adapter;
    ArrayList<CartProduct> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cart_full);

        binding = ActivityCartFullBinding.inflate(getLayoutInflater());
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
        addEvents();
        loadData();
    }


    private void addEvents() {
        binding.btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open sub activity 1
                Intent intent = new Intent(Cart_Full.this, Payment_Address.class);
                startActivity(intent);
            }
        });


    }

    private void loadData() {
        productList = new ArrayList<>();
        productList.add(new CartProduct(R.drawable.sanpham1, "ANF 6Free Natural Indoor Adult Cat",  02, 530000 ));
        productList.add(new CartProduct(R.drawable.sanpham4, "Natural Clumping Baby powder",  01, 120000 ));
        productList.add(new CartProduct(R.drawable.sanpham6, "Natural core C1 Bene kitten",  03, 100000 ));
        productList.add(new CartProduct(R.drawable.sanpham7, "Natural Signature made with salmon 1,6kg",  02, 400000 ));
        productList.add(new CartProduct(R.drawable.sanpham19, "SmartHeart Power Pack Puppy 20kg",  01, 1000000 ));

        adapter = new CartProductAdapter(Cart_Full.this, R.layout.cart_item_list,productList);
        binding.gvProduct.setAdapter(adapter);

    }
}