package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

        mangbienbao.add(new BienBaoModels("101", "Biển báo cấm", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("102", "Biển báo cấm vượt", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("103", "Biển báo cấm ô tô", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("104", "Biển báo cấm xe máy", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("105", "Biển báo cấm xe đạp", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("106", "Biển báo cấm xe thô sơ", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("107", "Biển báo cấm đi bộ", "Đây là biển báo cấm", null));
        mangbienbao.add(new BienBaoModels("108", "Biển báo cấm vượt", "Đây là biển báo cấm", null));

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
