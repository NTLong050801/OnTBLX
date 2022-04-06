package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import adapter.DapAnAdapter;
import database.DataBase;

public class lamdethi extends AppCompatActivity {
    TextView titleDeThi,tvDaLam,CauhoiDethi;
    Button btnend;
    ListView lvDapAnDeThi;
    ImageButton imgnext,imgback;
    private int pos = 0;
    private  int[] listCauhoiDe;
    ArrayList<CauHoi> listCauhoi = new ArrayList<>();
    ArrayList<DapAn> dapAnArrayList = new ArrayList<>();
    DapAnAdapter dapAnAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamdethi);
        anhxa();
        Intent intent = getIntent();
        int sode = intent.getIntExtra("sode",0);
        titleDeThi.setText("Đề số:"+sode);
        if(sode == 1){
             listCauhoiDe = new int[] {1,3,5,6,7};
        }
        if(sode == 2){
             listCauhoiDe = new int[] {4,5,8,10,1};
        }
        if(sode == 3){
           listCauhoiDe = new int[]  {9,2,11,12,13};
        }
        DataBase dataBase = new DataBase(this,"OnThiBLX.sqlite",null,1);
//        Toast.makeText(this, ""+listCauhoiDe[1], Toast.LENGTH_SHORT).show();
        for (int i = 0 ; i<listCauhoiDe.length;i++){
            String sql = "SELECT * from CauHoi where MaCauHoi = "+listCauhoiDe[i]+"";
           Cursor cursor =  dataBase.GetData(sql);
           while (cursor.moveToNext()){
               Integer MaCauHoi = cursor.getInt(0);
               Integer MaLoaiCauHoi = cursor.getInt(2);
               String NoiDung = cursor.getString(1);
               byte[] HinhAnh = cursor.getBlob(3);
               CauHoi cauHoi = new CauHoi(MaCauHoi,MaLoaiCauHoi,NoiDung,HinhAnh);
               listCauhoi.add(cauHoi);

           }
        }


        CauHoi cauHoi_get = listCauhoi.get(pos);
        CauhoiDethi.setText(cauHoi_get.getNoiDung());
        String sql1 = "SELECT * from DapAn where MaCauHoi = "+cauHoi_get.getMaCauHoi()+"";
        Cursor cursor_dapan = dataBase.GetData(sql1);
        while (cursor_dapan.moveToNext()){
            Integer MaDapAn = cursor_dapan.getInt(0);
            Integer MaCauhoi = cursor_dapan.getInt(1);
            String NoiDungDapAn = cursor_dapan.getString(2);
            Integer DapAnDung = cursor_dapan.getInt(3);
            DapAn dapAn = new DapAn(MaDapAn,MaCauhoi,NoiDungDapAn,DapAnDung);
            dapAnArrayList.add(dapAn);
        }
        dapAnAdapter = new DapAnAdapter(this,R.layout.item_dapan,dapAnArrayList);
        lvDapAnDeThi.setAdapter(dapAnAdapter);
        imgback.setVisibility(View.INVISIBLE);
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    imgback.setVisibility(View.VISIBLE);
                    pos = pos+1;
                    CauHoi cauHoi_get1 = listCauhoi.get(pos);

                    CauhoiDethi.setText(cauHoi_get1.getNoiDung());
                if(pos == listCauhoi.size()-1){
                    imgnext.setVisibility(View.INVISIBLE);
                }
//                Toast.makeText(lamdethi.this, ""+pos, Toast.LENGTH_SHORT).show();
                ArrayList<DapAn> dapAnArrayList1 = new ArrayList<>();
                String sql1 = "SELECT * from DapAn where MaCauHoi = "+cauHoi_get1.getMaCauHoi()+"";
                Cursor cursor_dapan = dataBase.GetData(sql1);
                while (cursor_dapan.moveToNext()){
                    Integer MaDapAn = cursor_dapan.getInt(0);
                    Integer MaCauhoi = cursor_dapan.getInt(1);
                    String NoiDungDapAn = cursor_dapan.getString(2);
                    Integer DapAnDung = cursor_dapan.getInt(3);
                    DapAn dapAn = new DapAn(MaDapAn,MaCauhoi,NoiDungDapAn,DapAnDung);
                    dapAnArrayList1.add(dapAn);
                }
                dapAnAdapter = new DapAnAdapter(lamdethi.this,R.layout.item_dapan,dapAnArrayList1);
                lvDapAnDeThi.setAdapter(dapAnAdapter);

            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = pos-1;
                imgnext.setVisibility(View.VISIBLE);
                CauHoi cauHoi_get2 = listCauhoi.get(pos);
                CauhoiDethi.setText(cauHoi_get2.getNoiDung());
                if(pos==0){
                    imgback.setVisibility(View.INVISIBLE);
                }
                ArrayList<DapAn> dapAnArrayList1 = new ArrayList<>();
                String sql1 = "SELECT * from DapAn where MaCauHoi = "+cauHoi_get2.getMaCauHoi()+"";
                Cursor cursor_dapan = dataBase.GetData(sql1);
                while (cursor_dapan.moveToNext()){
                    Integer MaDapAn = cursor_dapan.getInt(0);
                    Integer MaCauhoi = cursor_dapan.getInt(1);
                    String NoiDungDapAn = cursor_dapan.getString(2);
                    Integer DapAnDung = cursor_dapan.getInt(3);
                    DapAn dapAn = new DapAn(MaDapAn,MaCauhoi,NoiDungDapAn,DapAnDung);
                    dapAnArrayList1.add(dapAn);
                }
                dapAnAdapter = new DapAnAdapter(lamdethi.this,R.layout.item_dapan,dapAnArrayList1);
                lvDapAnDeThi.setAdapter(dapAnAdapter);
            }
        });
    }

    private void anhxa() {
        titleDeThi = findViewById(R.id.title_dethi);
        btnend = findViewById(R.id.btnend);
        CauhoiDethi = findViewById(R.id.tvCauhoi_dethi);
        imgnext = findViewById(R.id.imgNext);
        imgback = findViewById(R.id.imgBack);
        lvDapAnDeThi = findViewById(R.id.lvDapAnDeThi);
    }
}