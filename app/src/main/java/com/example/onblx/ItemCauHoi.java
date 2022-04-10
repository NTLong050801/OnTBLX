package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import adapter.DapAnAdapter;
import database.DataBase;

public class ItemCauHoi extends AppCompatActivity {
    private static int save = -1,stt,stt_da_dung;
    private  static  String title , sql;
    ListView lvDapAn;
    ImageView bienbao;
    ImageButton imgbtnBack,imgbtnNext;
    TextView tvCauhoi , tvDapAn,tvDapanDung,sttCauHoi;
    Toolbar tbtitle;
    Button btnCheck;
    Model model;
    ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    ArrayList<DapAn> dapAnArrayList = new ArrayList<>();
    DapAnAdapter dapAnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_cau_hoi);
        anhxa();
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tbtitle.setTitle(title+"");
        int pos = intent.getIntExtra("pos",0);
        stt = 0;
       model = new Model(this);
        if(pos == 0){
            sql = "SELECT * from Cauhoi ";
        }else {
            sql = "SELECT * from Cauhoi where MaLoaiCauhoi = " +pos;
        }
        if(pos == 1){
            bienbao.setVisibility(View.GONE);
        }
        setCauHoi();


        imgbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    stt = stt + 1;
                    setCauHoi();
            }
        });
        imgbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    stt = stt - 1;
                    setCauHoi();

            }
        });
        lvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               int dem = 0;
               for (DapAn dapAn_dung :dapAnArrayList){
                   dem++;
                   if(dapAn_dung.getDapAnDung()==1){
                       stt_da_dung = dem;
                   }
               }
               adapterView.getChildAt(i).setBackgroundColor(Color.GRAY);
               if (save != -1 && save != i){
                   adapterView.getChildAt(save).setBackgroundColor(Color.WHITE);
               }
               save = i;
               btnCheck.setVisibility(View.VISIBLE);
               //Toast.makeText(ItemCauHoi.this, DapanDung, Toast.LENGTH_SHORT).show();
               btnCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                tvDapanDung.setText("Đán án "+ stt_da_dung +" là đáp án đúng");
                tvDapanDung.setVisibility(View.VISIBLE);
                    adapterView.getChildAt(stt_da_dung-1).setBackgroundColor(Color.GREEN);
                }
        });
           }
       });
    }
//    private void change_background(AdapterView<?> DapAnAdapter){
//        btnCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvDapanDung.setText("Đán án "+ stt_da_dung +" là đáp án đúng");
//                tvDapanDung.setVisibility(View.VISIBLE);
//                DapAnAdapter.getChildAt(stt_da_dung-1).setBackgroundColor(Color.GREEN);
//            }
//        });
//    }
    private  void setCauHoi(){
        listCauHoi = model.get_cauHoi(sql);
        //Toast.makeText(this, ""+listCauHoi.size(), Toast.LENGTH_SHORT).show();
        CauHoi cauHoi = listCauHoi.get(stt);
        tvCauhoi.setText("Câu " + (stt+1) + " :" + cauHoi.getNoiDung());
        btnCheck.setVisibility(View.INVISIBLE);
        tvDapanDung.setVisibility(View.INVISIBLE);
        byte[] imgBienBao = cauHoi.getHinhBienBao();
        if(imgBienBao != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgBienBao, 0, imgBienBao.length);
            bienbao.setImageBitmap(bitmap);
            bienbao.setVisibility(View.VISIBLE);
        }else {
            bienbao.setVisibility(View.GONE);
        }
        if(stt == 0){
            imgbtnBack.setVisibility(View.INVISIBLE);
        }else {
            imgbtnBack.setVisibility(View.VISIBLE);
        }
        if(stt == (listCauHoi.size()-1)){
            imgbtnNext.setVisibility(View.INVISIBLE);
        }else {
            imgbtnNext.setVisibility(View.VISIBLE);
        }
        String sql_slt_dapan = "SELECT * From DapAn where MaCauHoi= "+cauHoi.getMaCauHoi()+"";
        dapAnArrayList = model.get_dapAn(sql_slt_dapan);
        dapAnAdapter = new DapAnAdapter(this,R.layout.item_dapan,dapAnArrayList);
        lvDapAn.setAdapter(dapAnAdapter);
        sttCauHoi.setText((stt+1)+"/"+listCauHoi.size());
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