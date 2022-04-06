package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import database.DataBase;

public class MainActivity extends AppCompatActivity {
    ListView lvCauhoi;
    LinearLayout OntapCauhoi,Dengaunhien,Thitheobode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase db = new DataBase(this,"OnThiBLX.sqlite",null,1);

        db.QueryData("Create table if not exists LoaiCauHoi(IDLoaiCauHoi Integer primary key autoincrement,TenLoaiCauHoi varchar)");

        //thêm dữ liệu
       // db.QueryData("INSERT INTO LoaiCauHoi Values(null,'Lý thuyết')");
        //lấy dữ liệu
        Anhxa();
        OntapCauhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, ontapcauhoi.class);
                startActivity(x);

            }
        });
        Dengaunhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, ItemCauHoi.class);
                startActivity(x);
            }
        });
        Thitheobode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, chondethi.class);
                startActivity(x);
            }
        });
    }

    private void Anhxa() {
        OntapCauhoi = (LinearLayout) findViewById(R.id.layout4);
        Dengaunhien = (LinearLayout) findViewById(R.id.layout11);
        Thitheobode = (LinearLayout) findViewById(R.id.layout2);

    }
}