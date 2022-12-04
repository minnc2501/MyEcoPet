package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.ProductAdapter;
import com.group11.Models.Product;
import com.group11.myecopet.databinding.ActivityShoppingBinding;

import java.util.ArrayList;

public class ShoppingActivity extends AppCompatActivity {
    ActivityShoppingBinding binding;
    public static SQLiteDatabase db;
    ArrayList<Product> products;
    ProductAdapter adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shopping);
        binding=ActivityShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        loadData();
        createEvents();
    }

    private void loadData() {
        //init data
        products= new ArrayList<>();
        products.add(new Product(1,"ANF 6Free Natural Indoor Adult Cat – Thức ăn hạt khô dành cho mèo trưởng thành",R.drawable.sanpham1, "530,000 ₫ – 1,400,000 ₫"));
        products.add(new Product(2,"ANF 6Free Natural Indoor Adult Cat – Thức ăn hạt khô dành cho mèo trưởng thành",R.drawable.sanpham2, "530,000 ₫ – 1,400,000 ₫"));
        products.add(new Product(3,"Natural Clumping Lavender – Cát ấn độ huơng hoa oải huơng",R.drawable.sanpham3, "120.00₫"));
        products.add(new Product(4,"Natural Clumping Baby powder – Cát ấn độ huơng phấn em bé",R.drawable.sanpham4, "120.00₫"));
        products.add(new Product(5,"Natural core C1 Bene adult chicken & salmon – thức ăn hạt khô cho mèo thịt gà và cá hồi",R.drawable.sanpham5, "75,000 ₫ – 740,000 ₫"));
        products.add(new Product(6,"Natural core C1 Bene kitten – thức ăn hạt khô cho mèo con",R.drawable.sanpham6, "69,000 ₫ – 630,000 ₫"));
        products.add(new Product(7,"Natural Signature made with salmon 1,6kg – Hạt hữu cơ cho mèo cá hồi",R.drawable.sanpham7, "399.00₫"));
        products.add(new Product(8,"Prunus natural herb shampoo – sữa tắm chứa thảo mộc và chất kháng khuẩn tự nhiên 500ml",R.drawable.sanpham8, "230.00₫"));
        products.add(new Product(9,"ANF 6Free Natural Indoor Kitten – Thức ăn hạt dành cho mèo con dưới 12 tháng tuổi",R.drawable.sanpham10, "55,000 ₫ – 1,400,000 ₫"));
        products.add(new Product(10,"Daily Best for Dog 60 – Viên nén bổ sung Vitamin tổng hợp",R.drawable.sanpham11, "296.00₫"));
        products.add(new Product(11,"Áo noel cho chó mèo",R.drawable.sanpham12, "95.00₫"));
        products.add(new Product(12,"Áo tết cho chó mèo",R.drawable.sanpham13, "160.00₫"));
        products.add(new Product(13,"Balo vận chuyển trứng bọ hung trong suốt cho chó mèo",R.drawable.sanpham14, "550.00₫"));
        products.add(new Product(14,"Khay Vệ Sinh Cao Cấp Cho Chó Nhỏ",R.drawable.sanpham15, "250.00₫"));
        products.add(new Product(15,"Doyoga soft supermeal dog food 1.2kg – Hạt mềm cho chó vị vịt",R.drawable.sanpham16, "330.00₫"));
        products.add(new Product(16,"Equilibrio adult salmon 1.5kg – Hạt dành cho mèo trưởng thành vị cá hồi",R.drawable.sanpham17, "259.00₫"));
        products.add(new Product(17,"SmartHeart Power Pack Puppy 20kg – Cho chó con dưới 12 tháng tuổi",R.drawable.sanpham19, "1,300,000 ₫"));
        products.add(new Product(18,"SmartHeart Puppy Beef & Milk 400g – Vị bò & sữa",R.drawable.sanpham20, "27.00₫"));

        //Init data

        adpater= new ProductAdapter(ShoppingActivity.this, R.layout.product_item,products);

        binding.gvProduct.setAdapter(adpater);
    // Data for time dialog

    }

    private void createEvents() {
//        BACK BUTTON
        ImageView backIcon =findViewById(R.id.imvBack);
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, MainScreen.class);
                startActivity(intent);
            }
        });

        binding.gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product= products.get(i);
                //Truyền dữ liệu
                Intent intent= new Intent(ShoppingActivity.this,ChitietSanPhamActivity.class);
                //Attach data
                intent.putExtra("name",products.get(i).getProductName());
                intent.putExtra("price",products.get(i).getProductPrice());
                intent.putExtra("image",products.get(i).getImage());
                startActivity(intent);
            }
        });
//Dialog Bộ lọc
        binding.btnBoLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, DialogBoloc.class);
                startActivity(intent);
                //Gán data source vào đối tượng ArrayAdapter

            }
        });

        binding.lnMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnThucAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.lnVatPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
            }
        });


        binding.btnSapXep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ShoppingActivity.this);
                dialog.setContentView(R.layout.dialog_sapxeptheo);

                Button btnHoanTac, btnXacnhan;
                ImageView imvSapXepBack;

                imvSapXepBack =dialog.findViewById(R.id.imv_SapXepBack);
                imvSapXepBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btnHoanTac = dialog.findViewById(R.id.btn_HoanTac);
                btnHoanTac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                btnXacnhan = dialog.findViewById(R.id.btn_Xacnhan);
                btnXacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ShoppingActivity.this, "Chức năng sẽ sớm cập nhật", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

}