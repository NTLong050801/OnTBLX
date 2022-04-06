package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.onblx.Adapter.BienBaoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LinearLayout deNgauNhien, bienBaoGiaoThong;
    RecyclerView rcvData;
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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);
        
        BienBaoAdapter bienBaoAdapter = new BienBaoAdapter();

        bienBaoAdapter.setData(getListBienBao());

    }

    private List<BienBaoModels> getListBienBao() {
        Model model = new Model(this);
        BienBaoModels bienBaoModels = model.getBienBao().get(0);
        List<BienBaoModels> list = new ArrayList<>();

        Bitmap bitmap = BitmapFactory.decodeByteArray(bienBaoModels.getImgBienbao(), 0, bienBaoModels.getImgBienbao().length);
        list.add(new BienBaoModels(bienBaoModels.getImgBienbao(), bienBaoModels.getMaBienBao(), bienBaoModels.getTenBienBao(), bienBaoModels.getyNghiaBienBao()));
        return list;
    }

    private void AnhXa(){
        deNgauNhien = (LinearLayout) findViewById(R.id.deNgauNhien);
        bienBaoGiaoThong = (LinearLayout) findViewById(R.id.bienBaoGiaoThong);
        rcvData = (RecyclerView) findViewById(R.id.rcvData);
        Model model = new Model(this);
        CauHoi cauhois = model.getData().get(0);
    }
}