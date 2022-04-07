package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class chiTietBienBao extends AppCompatActivity {
    TextView tvMaTenBienBao, tvYNghiaBienBao;
    ImageView imgBienBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bien_bao);
    }

    private void AnhXa(){
        tvMaTenBienBao = (TextView) findViewById(R.id.tvMaTenBienBao);
        tvYNghiaBienBao = (TextView) findViewById(R.id.tvYNghiaBienBao);
        imgBienBao = (ImageView) findViewById(R.id.imgBienBao);
    }
}