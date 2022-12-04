package com.group11.myecopet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.TimeAdapter;
import com.group11.Models.Time;
import com.group11.myecopet.databinding.ActivityDialogBolocBinding;

import java.util.ArrayList;

public class DialogBoloc extends AppCompatActivity {
    ActivityDialogBolocBinding binding;
    TimeAdapter adapter;
    ArrayList<Time> brandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dialog_boloc);
        binding = ActivityDialogBolocBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {

        binding.btnHoanTac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DialogBoloc.this, "Đã hoàn tác", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DialogBoloc.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DialogBoloc.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        brandList = new ArrayList<>();

        brandList.add(new Time("Smarthe"));
        brandList.add(new Time("Ganador"));
        brandList.add(new Time("ANFine"));
        brandList.add(new Time("Britinee"));
        brandList.add(new Time("Zenith"));
        brandList.add(new Time("Royal Canin"));
        brandList.add(new Time("Pedigree"));
        brandList.add(new Time("Nutrience"));
        brandList.add(new Time("Natural"));
        adapter = new TimeAdapter(DialogBoloc.this,R.layout.grid_item,brandList);
        //Đưa dữ liệu lên GridView thông qua đối tượng ArrayAdapter
        binding.gvThuonghieu.setAdapter(adapter);
    }
}