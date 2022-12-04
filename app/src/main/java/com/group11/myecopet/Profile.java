package com.group11.myecopet;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.group11.Models.profile;
import com.group11.myecopet.databinding.ActivityProfileBinding;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    Intent intent;
    ActivityResultLauncher<Intent> launcher;
    DatabaseProfile db1;
    ArrayList<profile> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_profile);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quaylai();
        createDB();
        loadData();
    }

    private void loadData() {
        profiles = new ArrayList<>();
        Cursor c = db1.getData(" SELECT * FROM " + DatabaseProfile.TBL_NAME1);
        while (c.moveToNext()) {
            profiles.add(new profile(c.getInt(0), c.getString(1),c.getString(2), c.getString(3), c.getString(4)));

        }
        c.close();
    }


    private void createDB() {
        db1 = new DatabaseProfile(Profile.this);
        db1.createSampleData();
    }


    private void quaylai() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,
                        Setting_Activity.class);

                startActivity(intent);
            }
        });
    }

    public void openDialogUpdateProfile(profile profile) {

        Dialog dialog = new Dialog(Profile.this);
        dialog.setContentView(R.layout.dialog_update_profile);


        EditText edtHo, edtTen, edtEmail,edtSDT;
        Button btnLuu;

        edtHo = dialog.findViewById(R.id.edt_SuaHo);
        edtHo.setText(profile.getHo());

        edtTen = dialog.findViewById(R.id.edt_SuaTen);
        edtTen.setText(profile.getTen());

        edtEmail = dialog.findViewById(R.id.edt_SuaEmail);
        edtEmail.setText(profile.getEmail());

        edtSDT = dialog.findViewById(R.id.edt_SuaSDT);
        edtSDT.setText(profile.getSDT());

        btnLuu = dialog.findViewById(R.id.btn_Luu);
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db1.execSql("UPDATE " + DatabaseProfile.TBL_NAME1 + " SET " +
                        DatabaseProfile.COL_HO + " = '" +
                        edtHo.getText().toString() + "', " +
                        DatabaseProfile.COL_TEN + " = '" +
                        edtTen.getText().toString() + "', " +
                        DatabaseProfile.COL_EMAIL + " = '" +
                        edtEmail.getText().toString() + "', " +
                        DatabaseProfile.COL_SDT + " = '" +
                        edtSDT.getText().toString() + "', " +
                        " WHERE " + database_diachi.COL_ID + "=" + profile.getProfileID());

                dialog.dismiss();
                loadData();
            }
        });
        

    }
}