package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class chiTietBienBao extends AppCompatActivity {
    TextView tvMaTenBienBao, tvYNghiaBienBao;
    ImageView imgBienBao;
    String tenBienBao, yNghiaBB;
    ArrayList<BienBaoModels> mangbienbaoo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bien_bao);
        AnhXa();


        Intent intent = getIntent();
        String maBB = (String) intent.getStringExtra("maBienBao");
        Model model = new Model(chiTietBienBao.this);
        String sql = "SELECT * FROM BienBao where MaBienBao = '" + maBB + "'";
        mangbienbaoo = new ArrayList<>();
        mangbienbaoo = model.getChiTietBienBao(sql);
        tenBienBao = mangbienbaoo.get(0).getTenBienBao();
        yNghiaBB = mangbienbaoo.get(0).getyNghiaBienBao();
        Bitmap bitmap = BitmapFactory.decodeByteArray(mangbienbaoo.get(0).getImgBienbao(), 0,mangbienbaoo.get(0).getImgBienbao().length);
        tvMaTenBienBao.setText("Biển " + maBB + " " + tenBienBao);
        tvYNghiaBienBao.setText("" + yNghiaBB);
        imgBienBao.setImageBitmap(bitmap);
    }

    private void AnhXa(){
        tvMaTenBienBao = (TextView) findViewById(R.id.tvMaTenBienBao);
        tvYNghiaBienBao = (TextView) findViewById(R.id.tvYNghiaBienBao);
        imgBienBao = (ImageView) findViewById(R.id.imgBienBao);
    }
}