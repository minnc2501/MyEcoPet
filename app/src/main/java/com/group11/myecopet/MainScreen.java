package com.group11.myecopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.group11.Adapters.rcmProductAdapter;
import com.group11.Models.Product;
import com.group11.Models.rcmProduct;
import com.group11.myecopet.databinding.ActivityMainScreenBinding;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    ActivityMainScreenBinding binding;
    rcmProductAdapter adapter;
    ArrayList<rcmProduct> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_screen);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.menuBar.setSelectedItemId(R.id.home);
        binding.menuBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(), Setting_Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        Intent intent = getIntent();

        loadData();
        addEvens();
    }

    private void addEvens() {
        binding.btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        binding.btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, DichVuActivity.class);
                startActivity(intent);
            }
        });

        binding.lnMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnThucAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnVatPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreen.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });

        binding.gvRcmProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Truyền dữ liệu
                Intent intent= new Intent(MainScreen.this,ChitietSanPhamActivity.class);
                //Attach data
                intent.putExtra("name",products.get(i).getProductName());
                intent.putExtra("price",products.get(i).getProductPrice());
                intent.putExtra("image",products.get(i).getProductImage());
                startActivity(intent);
            }
        });
    }


    private void loadData() {
        products = new ArrayList<>();
        products.add(new rcmProduct(R.drawable.sanpham1,
                "ANF 6Free Natural Indoor Adult Cat – Thức ăn hạt khô dành cho mèo trưởng thành",
                "530,000 ₫ – 1,400,000 ₫"));
        products.add(new rcmProduct(R.drawable.sanpham2,
                "ANF 6Free Natural Indoor Kitten – Thức ăn hạt dành cho mèo con dưới 12 tháng tuổi",
                "530,000 ₫ – 1,400,000 ₫"));
        products.add(new rcmProduct(R.drawable.sanpham3,
                "Natural Clumping Lavender – Cát ấn độ huơng hoa oải huơng",
                "120,00₫"));
        products.add(new rcmProduct(R.drawable.sanpham4,
                "Natural Clumping Baby powder – Cát ấn độ huơng phấn em bé",
                "120,00₫"));
        products.add(new rcmProduct(R.drawable.sanpham13,
                "Áo tết cho chó mèo (Đầy đủ Size)",
                "160,00₫"));
        products.add(new rcmProduct(R.drawable.sanpham15,
                "Khay Vệ Sinh Cao Cấp Cho Chó Nhỏ",
                "250,00₫"));
        products.add(new rcmProduct(R.drawable.sanpham16,
                "Doyoga soft supermeal dog food 1.2kg – Hạt mềm cho chó vị vịt",
                "330,00₫"));
        products.add(new rcmProduct(R.drawable.sanpham17,
                "Equilibrio adult salmon 1.5kg – Hạt dành cho mèo vị cá hồi",
                "259,00₫"));
        adapter = new rcmProductAdapter(MainScreen.this, R.layout.item_rcmproduct, products);
        binding.gvRcmProduct.setAdapter(adapter);
    }
}