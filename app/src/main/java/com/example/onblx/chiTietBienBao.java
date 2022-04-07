package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        AnhXa();
        Intent intent = getIntent();
        int maBB = intent.getIntExtra("maBienBao", -1);
        Model model = new Model(this);
        String sql = "SELECT * FROM BienBao limit " + maBB;
        BienBaoModels bienbaos = model.getBienBaoCam(sql).get(0);

        tvMaTenBienBao.setText("Biển 100 biển cấm" );
        tvYNghiaBienBao.setText("Biển này cấm rồi nhé" );
        imgBienBao.setImageResource(R.drawable.camdibo);
    }

    private void AnhXa(){
        tvMaTenBienBao = (TextView) findViewById(R.id.tvMaTenBienBao);
        tvYNghiaBienBao = (TextView) findViewById(R.id.tvYNghiaBienBao);
        imgBienBao = (ImageView) findViewById(R.id.imgBienBao);
    }
}