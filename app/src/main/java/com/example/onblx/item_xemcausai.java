package com.example.onblx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import adapter.DapAnAdapter;

public class item_xemcausai extends AppCompatActivity {
    private static int save = -1, stt_da_dung;
    ListView lvDapAn;
    ImageView bienbao;
    ImageButton imgbtnBack,imgbtnNext;
    TextView tvCauhoi , tvDapAn,tvDapanDung,sttCauHoi;
    Toolbar tbtitle;
    Button btnCheck;

    ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    ArrayList<DapAn> dapAnArrayList = new ArrayList<>();
    DapAnAdapter dapAnAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_cau_hoi);
        anhxa();
        Model model = new Model(this);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("poss", 0);
        tbtitle.setTitle("Các câu sai");
        btnCheck.setVisibility(View.VISIBLE);
        btnCheck.setText("Xóa khỏi danh sách");
        imgbtnBack.setVisibility(View.GONE);
        imgbtnNext.setVisibility(View.GONE);
        sttCauHoi.setVisibility(View.GONE);
        listCauHoi = model.get_cauHoiSai();
        CauHoi cauHoi = listCauHoi.get(pos);
        tvCauhoi.setText(cauHoi.getNoiDung());
        byte[] imgBienBao = cauHoi.getHinhBienBao();
        if (imgBienBao != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgBienBao, 0, imgBienBao.length);
            bienbao.setImageBitmap(bitmap);
            bienbao.setVisibility(View.VISIBLE);
        } else {
            bienbao.setVisibility(View.GONE);
        }
        String sql = "SELECT * from DapAn where MaCauHoi = " + cauHoi.getMaCauHoi() + "";
        dapAnArrayList = model.get_dapAn(sql);
        dapAnAdapter = new DapAnAdapter(item_xemcausai.this, R.layout.item_dapan, dapAnArrayList);
        lvDapAn.setAdapter(dapAnAdapter);
        lvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int dem = 0;
                for (DapAn dapAn_dung : dapAnArrayList) {
                    dem++;
                    if (dapAn_dung.getDapAnDung() == 1) {
                        stt_da_dung = dem;
                    }
                }
                adapterView.getChildAt(i).setBackgroundColor(Color.GRAY);
                adapterView.getChildAt(stt_da_dung - 1).setBackgroundColor(Color.GREEN);
                tvDapanDung.setText("Đán án " + stt_da_dung + " là đáp án đúng");
                tvDapanDung.setVisibility(View.VISIBLE);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.delete_item(cauHoi.getMaCauHoi());
                setResult(11,intent);
               finish();
            }
        });
    }




    private void anhxa() {
        lvDapAn = findViewById(R.id.lvdapan);
        tbtitle = findViewById(R.id.tb_titlecauhoi);
        tvCauhoi = findViewById(R.id.item_cau_hoi);
        tvDapAn = findViewById(R.id.tvItemDapAn);
        tvDapanDung = findViewById(R.id.tvDapAnDung);
        btnCheck = findViewById(R.id.btnCheck);
        bienbao = findViewById(R.id.bienbao);
        imgbtnBack = findViewById(R.id.imgbtnBack);
        imgbtnNext = findViewById(R.id.imgbtnNext);
        sttCauHoi = findViewById(R.id.sttCauHoi);
    }
    }
