package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.Adapters.diachiadapter;
import com.group11.Models.diachi;
import com.group11.myecopet.databinding.ActivityDiaChiBinding;

import java.util.ArrayList;

public class DiaChi extends AppCompatActivity {

    ActivityDiaChiBinding binding;
    diachiadapter adapter;
    ArrayList<diachi> diachis;
    database_diachi db;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dia_chi);

        binding = ActivityDiaChiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createData();
        loadData();
        quaylai();
        sua();
        
    }
    private void createData() {
        db = new database_diachi(DiaChi.this);
        db.createSampleData();
    }

    private void sua() {
    }

    private void loadData() {

        diachis = new ArrayList<>();

        Cursor c = db.getData(" SELECT * FROM " + database_diachi.TBL_NAME);
        while (c.moveToNext()){
            diachis.add(new diachi(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4)));
        }
        c.close();


        adapter = new diachiadapter(DiaChi.this,R.layout.diachi_layout, diachis);

        binding.gvDiaChi.setAdapter(adapter);
    }

    private void quaylai() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaChi.this,
                        Setting_Activity.class);

                startActivity(intent);
            }
        });
    }


    public void openDialogUpdateDiachi (diachi diachi) {
        Dialog dialog = new Dialog(DiaChi.this);
        dialog.setContentView(R.layout.dialog_update_diachi);

        EditText edtHoTen, edtSDT, edtDiaChi,edtLoai;
        Button btnUpdate;

        edtHoTen = dialog.findViewById(R.id.edt_HoTen);
        edtHoTen.setText(diachi.getHoTen());
        edtDiaChi = dialog.findViewById(R.id.edt_DiaChi);
        edtDiaChi.setText(diachi.getDiaChi());
        edtSDT = dialog.findViewById(R.id.edt_SDT);
        edtSDT.setText(diachi.getSDT());
        edtLoai = dialog.findViewById(R.id.edt_Loai);
        edtLoai.setText(diachi.getLoai());

        btnUpdate = dialog.findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sửa
                db.execSql(" UPDATE " + database_diachi.TBL_NAME + " SET " +
                        database_diachi.COL_HOTEN + " = '" +
                        edtHoTen.getText().toString() + "', " +
                        database_diachi.COL_DIACHI + " = '" +
                        edtDiaChi.getText().toString() + "', " +
                        database_diachi.COL_SDT + " = '" +
                        edtSDT.getText().toString() + "', " +
                        database_diachi.COL_LOAI + " = '" +
                        edtLoai.getText().toString() + "', " +
                        " WHERE " + database_diachi.COL_ID + "=" + diachi.getdiachiID());

                loadData();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void openDialogAddDiachi (diachi diachi) {
        Dialog dialog = new Dialog(DiaChi.this);
        dialog.setContentView(R.layout.dialog_update_diachi);


        EditText edtHoTen, edtSDT, edtDiaChi,edtLoai;
        Button btnLuu;

        edtHoTen = dialog.findViewById(R.id.edt_HoTen);
        edtHoTen.setText(diachi.getHoTen());
        edtDiaChi = dialog.findViewById(R.id.edt_DiaChi);
        edtDiaChi.setText(diachi.getDiaChi());
        edtSDT = dialog.findViewById(R.id.edt_SDT);
        edtSDT.setText(diachi.getSDT());
        edtLoai = dialog.findViewById(R.id.edt_Loai);
        edtLoai.setText(diachi.getLoai());

        btnLuu = dialog.findViewById(R.id.btn_Luu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sửa
                db.execSql(" UPDATE " + database_diachi.TBL_NAME + " SET " +
                        database_diachi.COL_HOTEN + " = '" +
                        edtHoTen.getText().toString() + "', " +
                        database_diachi.COL_DIACHI + " = '" +
                        edtDiaChi.getText().toString() + "', " +
                        database_diachi.COL_SDT + " = '" +
                        edtSDT.getText().toString() + "', " +
                        database_diachi.COL_LOAI + " = '" +
                        edtLoai.getText().toString() + "', " +
                        " WHERE " + database_diachi.COL_ID + "=" + diachi.getdiachiID());

                loadData();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}