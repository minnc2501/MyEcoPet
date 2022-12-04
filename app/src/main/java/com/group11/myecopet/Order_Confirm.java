package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.CartProductAdapter;
import com.group11.Adapters.PaymentAddressAdapter;
import com.group11.Adapters.PaymentMethodAdapter;
import com.group11.Models.CartProduct;
import com.group11.Models.CustomerAddress;
import com.group11.Models.PaymentMethod;
import com.group11.myecopet.databinding.ActivityOrderConfirmBinding;

import java.util.ArrayList;

public class Order_Confirm extends AppCompatActivity {

    ActivityOrderConfirmBinding binding;
    PaymentAddressAdapter adapter1;
    PaymentMethodAdapter adapter2;
    CartProductAdapter adapter3;

    ArrayList<CartProduct> productList;
    ArrayList<CustomerAddress> addressList;
    ArrayList<PaymentMethod> methodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_confirm);
        binding = ActivityOrderConfirmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadDataAddress();
        loadDataCard();
        loadDataProduct();
        addEvents();
    }

    private void addEvents() {

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Order_Confirm.this, Payment_Method.class);
                startActivity(intent);
            }
        });

        binding.btnDatHangNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show Custom Dialog
                Dialog dialog = new Dialog(Order_Confirm.this);
                dialog.setContentView(R.layout.oder_success);


                Button exit = dialog.findViewById(R.id.btnThoat);
                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();


                Button follow = dialog.findViewById(R.id.btnTheoDoiDon);
                follow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Order_Confirm.this, Follow_Order.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }


    private void loadDataAddress() {
        addressList = new ArrayList<>();
        addressList.add(new CustomerAddress("Nguyen Thu Thao",  "5A, Đường số 5, Khu phố 2, Phường Linh Trung, TP. HCM", "0388593086" ));
        adapter1 = new PaymentAddressAdapter(Order_Confirm.this, R.layout.confirmed_address_list,addressList);
        binding.gvConfirmedAddress.setAdapter(adapter1);
    }

    private void loadDataCard() {
        methodList = new ArrayList<>();
        methodList.add(new PaymentMethod(R.drawable.logo_visa,"Visa", "xxxx xxxx xxxx 1704"));

        adapter2 = new PaymentMethodAdapter(Order_Confirm.this, R.layout.confirmed_card_list, methodList);
        binding.gvConfirmedCard.setAdapter(adapter2);
    }

    private void loadDataProduct() {
        productList = new ArrayList<>();
        productList.add(new CartProduct(R.drawable.sanpham1, "ANF 6Free Natural Indoor Adult Cat",  02, 1060000 ));
        productList.add(new CartProduct(R.drawable.sanpham4, "Natural Clumping Baby powder",  01, 120000 ));
        productList.add(new CartProduct(R.drawable.sanpham6, "Natural core C1 Bene kitten",  03, 300000 ));

        adapter3 = new CartProductAdapter(Order_Confirm.this, R.layout.confirmed_product_list,productList);
        binding.gvConfirmedProduct.setAdapter(adapter3);

    }
}