package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import adapter.DapAnAdapter;
import database.DataBase;

public class ItemCauHoi extends AppCompatActivity {
    private static int save = -1,stt,i_get;
    private  static  String title;
    ListView lvDapAn;
    ImageView bienbao;
    ImageButton imgbtnBack,imgbtnNext;
    TextView tvCauhoi , tvDapAn,tvDapanDung;
    Toolbar tbtitle;
    Button btnCheck;
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
        int i = intent.getIntExtra("i",0);
        i_get=i;
        if(pos == 1){
            bienbao.setVisibility(View.GONE);
        }
        if(i==0){
            imgbtnBack.setVisibility(View.INVISIBLE);
        }else {
            imgbtnBack.setVisibility(View.VISIBLE);
        }
        DataBase dataBase = new DataBase(this);
        String sql = "SELECT * from Cauhoi where MaLoaiCauhoi = "+pos+" limit "+i+",1";
        Cursor cursor = dataBase.GetData(sql);
        while (cursor.moveToNext()) {
            CauHoi cauhoi = new CauHoi(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),cursor.getBlob(3));
            listCauHoi.add(cauhoi);
            tvCauhoi.setText(cursor.getString(1));
        }

        Cursor cursor_da = dataBase.GetData("SELECT * From DapAn where MaCauHoi="+(i+1)+"");
        while (cursor_da.moveToNext()){
            Integer maDapAn = cursor_da.getInt(0);
            Integer maCauHoi = cursor_da.getInt(1);
            Integer maDapAnDung = cursor_da.getInt(3);
            String noiDung = cursor_da.getString(2);
            DapAn dapAn = new DapAn(maDapAn,maCauHoi,noiDung,maDapAnDung);
            dapAnArrayList.add(dapAn);
        }

        dapAnAdapter = new DapAnAdapter(this,R.layout.item_dapan,dapAnArrayList);
        int dem = 0;
        for (DapAn dapAn_dung :dapAnArrayList){
            dem++;
            if(dapAn_dung.getDapAnDung()==1){
                stt = dem;
            }
        }
        lvDapAn.setAdapter(dapAnAdapter);
        lvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               adapterView.getChildAt(i).setBackgroundColor(Color.GRAY);
               if (save != -1 && save != i){
                   adapterView.getChildAt(save).setBackgroundColor(Color.WHITE);
               }
               save = i;
               String checkdapan = ((TextView) view.findViewById(R.id.checkDapan)).getText().toString();
               btnCheck.setVisibility(View.VISIBLE);
               //Toast.makeText(ItemCauHoi.this, DapanDung, Toast.LENGTH_SHORT).show();
               btnCheck.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       tvDapanDung.setText("Đán án "+ stt +" là đáp án đúng");
                       tvDapanDung.setVisibility(View.VISIBLE);
                       adapterView.getChildAt(stt-1).setBackgroundColor(Color.GREEN);
                   }
               });
           }
       });


//        imgbtnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                i_get++;
//                Intent x = new Intent(ItemCauHoi.this, ItemCauHoi.class);
//                x.putExtra("i",i_get);
//                x.putExtra("pos",pos);
//                x.putExtra("title",title);
//                startActivity(x);
//
//            }
//        });
//        imgbtnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                i_get--;
//                Intent x = new Intent(ItemCauHoi.this, ItemCauHoi.class);
//                x.putExtra("i",i_get);
//                x.putExtra("pos",pos);
//                x.putExtra("title",title);
//                startActivity(x);
//
//            }
//        });
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
    }
}