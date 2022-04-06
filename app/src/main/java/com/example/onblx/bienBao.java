package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

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

//        for(int i = 0 ; i<= model.getBienBao().size(); i++){
//            BienBaoModels dsbienbao = model.getBienBao().get(i);
//            mangbienbao.add(new BienBaoModels(dsbienbao.getMaBienBao(), dsbienbao.getTenBienBao(), dsbienbao.getyNghiaBienBao(), null));
//
//        }
        BienBaoModels dsbienbao = model.getBienBao().get(0);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(dsbienbao.getImgBienBao(), 0, dsbienbao.getImgBienBao().length);
       mangbienbao.add(new BienBaoModels(dsbienbao.getMaBienBao(), dsbienbao.getTenBienBao(), dsbienbao.getyNghiaBienBao(), null));
        mangbienbao.add(new BienBaoModels("99", "bIỂN BÁO GÌ ĐÓ", "ý NGHĨA BIỂN BÁO", null));
        mangbienbao.add(new BienBaoModels("98", "BIỂN BÁO GÌ ĐÓ", "ý NGHĨA BIỂN BÁO", null));

        BienBaooAdapter bbAdapter = new BienBaooAdapter(
                bienBao.this,
                R.layout.item_bienbao,
                mangbienbao
        );

        lvBienBao.setAdapter(bbAdapter);
    }

    private void AnhXa(){
        lvBienBao = (ListView) findViewById(R.id.lvBienBao);
        mangbienbao = new ArrayList<BienBaoModels>();
    }
}
