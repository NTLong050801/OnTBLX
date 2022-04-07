package com.example.onblx;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
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

        Model model = new Model(this);
        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql = "SELECT * FROM BienBao where LoaiBienBao ='Biển báo cấm'";
                BienBaooAdapter bbAdapter = new BienBaooAdapter(
                        bienBao.this,
                        R.layout.item_bienbao,
                        model.getBienBaoCam(sql)

                );
                lvBienBao.setAdapter(bbAdapter);
            }
        });
        btnHieuLenh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sql = "SELECT * FROM BienBao where LoaiBienBao ='Biển hiệu lệnh'";
                BienBaooAdapter bbAdapter = new BienBaooAdapter(
                        bienBao.this,
                        R.layout.item_bienbao,
                        model.getBienBaoCam(sql)

                );
                lvBienBao.setAdapter(bbAdapter);
            }
        });



//        for(int i = 0 ; i<= 5; i++){
//            BienBaoModels dsbienbao = model.getBienBaoCam(sql).get(i);
//            mangbienbao.add(new BienBaoModels(dsbienbao.getMaBienBao(), dsbienbao.getTenBienBao(), dsbienbao.getyNghiaBienBao(), dsbienbao.getImgBienbao()));
//        }

//

//


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
        btnCam = findViewById(R.id.btnBienBaoCam);
        btnHieuLenh = findViewById(R.id.btnBienBaoHl);
    }
}
