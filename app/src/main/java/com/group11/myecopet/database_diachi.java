package com.group11.myecopet;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database_diachi extends SQLiteOpenHelper {

    public static final String DB_NAME = "address.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME = "Address";
    public static final String COL_ID = "diachiID";
    public static final String COL_HOTEN = "HoTen";
    public static final String COL_DIACHI = "DiaChi";
    public static final String COL_SDT = "SDT";
    public static final String COL_LOAI = "loai";

    public database_diachi(@Nullable Context context) {
        super(context, TBL_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TBL_NAME +
                " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_HOTEN + " VARCHAR(50), " +
                COL_DIACHI + " VARCHAR(200), " +
                COL_SDT + " VARCHAR(50), " +
                COL_LOAI + " VARCHAR(50))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TBL_NAME);
    }

    //SELECT
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    //INSERT, UPDATE, DELETE
    public void execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);

    }
    //KIỂM TRA TABLE CÓ DỮ LIỆU HAY KHÔNG
    public int numbOfRows(){
        Cursor cursor = getData(" SELECT * FROM " + TBL_NAME);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql(" INSERT INTO " + TBL_NAME + " VALUES(null, 'Nguyễn Thị Thanh Thảo', '213/8 Nguyễn Gia Trí, Bình Thạnh, Hồ Chí Minh', '0337902072', 'Nhà riêng')");
            execSql(" INSERT INTO " + TBL_NAME + " VALUES(null, 'Nguyễn Thị Thanh Thảo', '74 Tân Nghĩa, Di Linh, Lâm Đồng', '0337902072', 'Nhà riêng')");
        }
    }

}
