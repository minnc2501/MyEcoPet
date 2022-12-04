package com.group11.myecopet;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseProfile extends SQLiteOpenHelper {

    public static final String DB_NAME = "address.sqlite";
    public static final int DB_VERSION = 1;
    public static final String TBL_NAME1 = "Profile";
    public static final String COL_ID = "ProfileID";
    public static final String COL_TEN = "Ten";
    public static final String COL_HO = "Ho";
    public static final String COL_EMAIL = "Email";
    public static final String COL_SDT = "SDT";

    public DatabaseProfile (@Nullable Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TBL_NAME1 +
                " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TEN + " VARCHAR(50), " +
                COL_HO + " VARCHAR(200), " +
                COL_EMAIL + " VARCHAR(50), " +
                COL_SDT + " VARCHAR(50))";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME1);
        onCreate(sqLiteDatabase);
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
        Cursor cursor = getData("SELECT * FROM " + TBL_NAME1);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void createSampleData(){
        if(numbOfRows() == 0){
            execSql("INSERT INTO " + TBL_NAME1 + " VALUES(null, 'Thao', 'Nguyen', 'thaontt19410@st.uel.edu.vn', '0337902072')");
        }
    }
}

