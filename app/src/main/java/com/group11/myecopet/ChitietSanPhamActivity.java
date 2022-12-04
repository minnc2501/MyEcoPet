package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityChitietSanPhamBinding;

public class ChitietSanPhamActivity extends AppCompatActivity {
    ActivityChitietSanPhamBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chitiet_san_pham);
        binding = ActivityChitietSanPhamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Nhan data
        Intent intent= getIntent();
        binding.txtProductName.setText(intent.getStringExtra("name"));
        binding.txtProductPrice.setText(intent.getStringExtra("price"));
        binding.imvProduct.setImageResource(intent.getIntExtra("image",0));

        addEvents();
    }



    private void addEvents() {
        ImageView backIcon =findViewById(R.id.imvBack);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChitietSanPhamActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        binding.btnThemvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChitietSanPhamActivity.this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChitietSanPhamActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
    }
}