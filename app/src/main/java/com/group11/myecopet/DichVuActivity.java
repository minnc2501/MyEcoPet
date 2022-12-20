package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.TimeAdapter;
import com.group11.Models.Time;
import com.group11.myecopet.databinding.ActivityDichVuBinding;

import java.util.ArrayList;

public class DichVuActivity extends AppCompatActivity {
    ActivityDichVuBinding binding;
    TimeAdapter adapter;
    ArrayList<Time> dsSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dich_vu);
        binding=ActivityDichVuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();

    }

    private void addEvents() {
        //Tạo nguồn dữ liệu cho Grid View (data source)
        dsSP = new ArrayList<>();

        dsSP.add(new Time("8:00"));
        dsSP.add(new Time("9:00"));
        dsSP.add(new Time("10:00"));
        dsSP.add(new Time("11:00"));
        dsSP.add(new Time("14:00"));
        dsSP.add(new Time("15:00"));
        dsSP.add(new Time("18:00"));
        dsSP.add(new Time("19:00"));
        dsSP.add(new Time("20:00"));

        //Gán data source vào đối tượng ArrayAdapter
        //Init data

        adapter= new TimeAdapter(DichVuActivity.this,R.layout.grid_item,dsSP);
        //Đưa dữ liệu lên GridView thông qua đối tượng ArrayAdapter
        binding.gvTime.setAdapter(adapter);
        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DichVuActivity.this, MainScreen.class);
                startActivity(intent);
            }
        });
        binding.btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DichVuActivity.this, "Yeah! Đặt lịch thành công, nhớ cùng boss đến đúng giờ nhé!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DichVuActivity.this, MainScreen.class);
                startActivity(intent);
            }
        });
    }
}