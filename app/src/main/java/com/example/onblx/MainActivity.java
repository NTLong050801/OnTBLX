package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase db = new DataBase(this,"OnThiBLX.sqlite",null,1);

        db.QueryData("Create table if not exists LoaiCauHoi(IDLoaiCauHoi Integer primary key autoincrement,TenLoaiCauHoi varchar)");

        //thêm dữ liệu
       // db.QueryData("INSERT INTO LoaiCauHoi Values(null,'Lý thuyết')");
        //lấy dữ liệu
        Cursor cursor = db.GetData("SELECT * from CauHoi");
        while (cursor.moveToNext()){
            Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
        }
    }
}