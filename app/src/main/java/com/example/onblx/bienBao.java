package com.example.onblx;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onblx.Adapter.BienBaooAdapter;

import java.util.ArrayList;

public class bienBao extends AppCompatActivity {
    ListView lvBienBao;
    Button btnCam,btnHieuLenh;
    ArrayList<BienBaoModels> mangbienbao;
    private  String sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bien_bao);

        AnhXa();


        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql = "SELECT * FROM BienBao where LoaiBienBao ='Biển báo cấm'";
               hienThiBienBao();
            }
        });
        btnHieuLenh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql = "SELECT * FROM BienBao where LoaiBienBao ='Biển hiệu lệnh'";
                hienThiBienBao();
            }
        });
        lvBienBao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(bienBao.this, "Vị trí click " +i, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void hienThiBienBao(){
        Model model = new Model(this);
        BienBaooAdapter bbAdapter = new BienBaooAdapter(
                bienBao.this,
                R.layout.item_bienbao,
                model.getBienBaoCam(sql)

        );
        lvBienBao.setAdapter(bbAdapter);
    }
    private void AnhXa(){
        lvBienBao = (ListView) findViewById(R.id.lvBienBao);
        mangbienbao = new ArrayList<BienBaoModels>();
        btnCam = findViewById(R.id.btnBienBaoCam);
        btnHieuLenh = findViewById(R.id.btnBienBaoHl);
    }
}
