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
    ListView lvBienBao;
    ArrayList<BienBaoModels> mangbienbao;
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



        //        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rcvData.setLayoutManager(linearLayoutManager);
//
//        BienBaoAdapter bienBaoAdapter = new BienBaoAdapter();
//
//        bienBaoAdapter.setData(getListBienBao());
//
//        rcvData.setAdapter(bienBaoAdapter);
    }

//    private List<BienBaoModels> getListBienBao() {
//        Model model = new Model(this);
//        BienBaoModels bienBaoModels = model.getBienBao().get(0);
//        List<BienBaoModels> list = new ArrayList<>();
//
////        Bitmap bitmap = BitmapFactory.decodeByteArray(bienBaoModels.getImgBienbao(), 0, bienBaoModels.getImgBienbao().length);
//        list.add(new BienBaoModels(R.drawable.biencam, bienBaoModels.getMaBienBao(), bienBaoModels.getTenBienBao(), bienBaoModels.getyNghiaBienBao()));
//        list.add(new BienBaoModels(R.drawable.biendung, bienBaoModels.getMaBienBao(), bienBaoModels.getTenBienBao(), bienBaoModels.getyNghiaBienBao()));
//        return list;
//    }

    private void AnhXa(){
        deNgauNhien = (LinearLayout) findViewById(R.id.deNgauNhien);
        bienBaoGiaoThong = (LinearLayout) findViewById(R.id.bienBaoGiaoThong);
        mangbienbao = new ArrayList<BienBaoModels>();
    }
}