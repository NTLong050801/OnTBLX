package com.example.onblx;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onblx.Adapter.BienBaooAdapter;

import java.util.ArrayList;

public class bienBao extends AppCompatActivity {
    ListView lvBienBao;
    ArrayList<BienBaoModels> mangbienbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bien_bao);

        AnhXa();
        Model model = new Model(this);

        for(int i = 0 ; i<= 2; i++){
            BienBaoModels dsbienbao = model.getBienBao().get(i);
            mangbienbao.add(new BienBaoModels(dsbienbao.getMaBienBao(), dsbienbao.getTenBienBao(), dsbienbao.getyNghiaBienBao(), dsbienbao.getImgBienbao()));
        }

        BienBaooAdapter bbAdapter = new BienBaooAdapter(
                bienBao.this,
                R.layout.item_bienbao,
                mangbienbao
        );

        lvBienBao.setAdapter(bbAdapter);

//        lvBienBao.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(bienBao.this, chiTietBienBao.class);
//                startActivity(intent);
//            }
//        });
    }

    private void AnhXa(){
        lvBienBao = (ListView) findViewById(R.id.lvBienBao);
        mangbienbao = new ArrayList<BienBaoModels>();
    }
}
