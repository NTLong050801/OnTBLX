package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout deNgauNhien, bienBaoGiaoThong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        deNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, listCauHoi.class);
                startActivity(intent);
            }
        });

        bienBaoGiaoThong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bienBao.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa(){
        deNgauNhien = (LinearLayout) findViewById(R.id.deNgauNhien);
        bienBaoGiaoThong = (LinearLayout) findViewById(R.id.bienBaoGiaoThong);

    }
}