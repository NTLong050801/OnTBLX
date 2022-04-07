package com.example.onblx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import adapter.DapAnAdapter;
import database.DataBase;

public class lamdethi extends AppCompatActivity {
    private static int save = -1;
    TextView titleDeThi,tvDaLam,CauhoiDethi,checkdapan,tvTimeout;
    Boolean counterIsactive = false;
    ImageView hinhCauHoi;
    Button btnend,btnCau1,btnCau2,btnCau3,btnCau4,btnCau5,btnCau6,btnCau7,btnCau8,btnCau9,btnCau10;
    ListView lvDapAnDeThi,lvCausai;
    ImageButton imgnext,imgback;
    CountDownTimer countDownTimer;
    private int pos = 0,CauDaLam;
    private  int[] listCauhoiDe,listCausai;
    private  int[] luuDapAn = new int[] {2,2,2,2,2,2,2,2,2,2};
    private  int[] sttDapAn = new int[] {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
    private  DataBase dataBase = new DataBase(this);
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
             listCauhoiDe = new int[] {1,3,5,6,7,16,19,22,26,27};
        }
        if(sode == 2){
             listCauhoiDe = new int[] {4,5,8,10,1,18,19,20,28,30};
        }
        if(sode == 3){
           listCauhoiDe = new int[]  {9,2,11,12,13,19,22,23,24,27,28};
        }

//        Toast.makeText(this, ""+listCauhoiDe[1], Toast.LENGTH_SHORT).show();
        for (int i = 0 ; i<listCauhoiDe.length;i++){
            String sql = "SELECT * from CauHoi where MaCauHoi = "+listCauhoiDe[i]+"";
           Cursor cursor =  dataBase.GetData(sql);
           while (cursor.moveToNext()){
               Integer MaCauHoi = cursor.getInt(0);
               Integer MaLoaiCauHoi = cursor.getInt(2);
               String NoiDung = cursor.getString(1);
               byte[] HinhAnh = cursor.getBlob(3);
                //Bitmap bitmap = BitmapFactory.decodeByteArray(cauhois.getHinhanh(), 0, cauhois.getHinhanh().length);
               //img_hinhAnh.setImageBitmap(bitmap);
               CauHoi cauHoi = new CauHoi(MaCauHoi,MaLoaiCauHoi,NoiDung,HinhAnh);
               listCauhoi.add(cauHoi);

           }
        }

        if(counterIsactive){

        }else {
            counterIsactive = true;
            countDownTimer = new CountDownTimer(30000,1000) {
                int sodapandung = 0;
                @Override
                public void onTick(long l) {
                    updateTimer((int) l/1000);
                }

                @Override
                public void onFinish() {
                    for(int a = 0 ; a< luuDapAn.length;a++){
                        if(luuDapAn[a] == 1){
                            sodapandung++;
                        }
                    }
                    AlertDialog.Builder thongbaodiem = new AlertDialog.Builder(lamdethi.this);
                    thongbaodiem.setTitle("Hết giờ !!!");
                    thongbaodiem.setMessage("Bạn đúng "+sodapandung +"/10");
                    thongbaodiem.setIcon(R.drawable.ic_checked);
                    thongbaodiem.setPositiveButton("Làm đề khác", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent.putExtra("socaudung",sodapandung);
                            setResult(11,intent);
                            finish();

                        }
                    });
                    thongbaodiem.setNegativeButton("Làm lại", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                    thongbaodiem.show();
                }
            }.start();
        }

        setDapAnAdapter();
        chondapan();
        imgback.setVisibility(View.INVISIBLE);
        imgnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    imgback.setVisibility(View.VISIBLE);
                    pos = pos+1;
                    setDapAnAdapter();
                if(pos == listCauhoi.size()-1){
                    imgnext.setVisibility(View.INVISIBLE);
                }
                chondapan();


            }
        });
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = pos-1;
                imgnext.setVisibility(View.VISIBLE);
                setDapAnAdapter();
                if(pos==0){
                    imgback.setVisibility(View.INVISIBLE);
                }
                chondapan();

            }
        });
        //click kết thúc
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hiển thị dialog xác nhận nộp bài
                AlertDialog.Builder dialog = new AlertDialog.Builder(lamdethi.this);
                dialog.setTitle("Thông báo");
                dialog.setMessage("Bạn chắc chắn nộp bài ?");
                dialog.setIcon(R.drawable.img);
                dialog.setPositiveButton("Nộp", new DialogInterface.OnClickListener() {
                    int sodapandung = 0;

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counterIsactive = false;
                        countDownTimer.cancel();
                        for(int a = 0 ; a< luuDapAn.length;a++){
                            if(luuDapAn[a] == 1){
                                sodapandung++;
                            }
                        }
                        AlertDialog.Builder thongbaodiem = new AlertDialog.Builder(lamdethi.this);
                        thongbaodiem.setTitle("Nộp bài thành công");
                        thongbaodiem.setMessage("Bạn đúng "+sodapandung +"/10");
                        thongbaodiem.setIcon(R.drawable.ic_checked);
                        thongbaodiem.setPositiveButton("Làm đề khác", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                intent.putExtra("socaudung",sodapandung);
                                setResult(11,intent);
                                finish();

                            }
                        });
                        thongbaodiem.setNegativeButton("Làm lại", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                startActivity(getIntent());
                            }
                        });
                        thongbaodiem.show();
                    }
                });
                dialog.setNegativeButton("Tiếp tục làm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });

        btnCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });
        btnCau10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ClickCauhoi(view); }
        });

    }
    private  void  updateTimer(int secondsLeft){
        // vd : 70 giay
        //tính số phút : 1p
        int phut = secondsLeft/60;
        //tính số giây còn lại = 70-(1*60)
        int giay = secondsLeft -(phut * 60);
        // chuyển về chuuooix
        String strGiay = Integer.toString(giay);
        // nếu giây < 9 thì thêm số 0 đằng trước
        if(giay <=9){
            strGiay = "0"+ strGiay;
        }
        tvTimeout.setText(Integer.toString(phut)+":"+strGiay);
    }
    private void ClickCauhoi(View view) {
        Button btnCauhoi =(Button)view;

        switch (view.getId()){
            case R.id.btnCau1:{
                pos = 0;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau2:{
                pos = 1;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau3:{
                pos = 2;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau4:{
                pos = 3;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau5:{
                pos = 4;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau6:{
                pos = 5;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau7:{
                pos = 6;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau8:{
                pos = 7;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau9:{
                pos = 8;
                setDapAnAdapter();
                break;
            }
            case R.id.btnCau10:{
                pos = 9;
                setDapAnAdapter();
                break;
            }
        }
        if(pos == 0){
            imgback.setVisibility(View.INVISIBLE);
        }else {
            imgback.setVisibility(View.VISIBLE);
        }
        if(pos == 9){
            imgnext.setVisibility(View.INVISIBLE);
        }else {
            imgnext.setVisibility(View.VISIBLE);
        }
    }

    private  void setDapAnAdapter(){
        ArrayList<DapAn> dapAnArrayList1 = new ArrayList<>();
        CauHoi cauHoi_get = listCauhoi.get(pos);
        //img_hinhAnh.setImageBitmap(bitmap);
        byte[] imgCauhoi = cauHoi_get.getHinhBienBao();
        if(imgCauhoi != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgCauhoi, 0, imgCauhoi.length);
            hinhCauHoi.setImageBitmap(bitmap);
            hinhCauHoi.setVisibility(View.VISIBLE);
        }else {
            hinhCauHoi.setVisibility(View.GONE);
        }
        CauhoiDethi.setText("Câu "+ (pos+1)+": "+cauHoi_get.getNoiDung());
        String sql1 = "SELECT * from DapAn where MaCauHoi = "+cauHoi_get.getMaCauHoi()+"";
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
//        lvDapAnDeThi.

    }
    private  void chondapan(){
        lvDapAnDeThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(sttDapAn[pos] == -2){
                    CauDaLam = CauDaLam+1;

                }
                adapterView.getChildAt(i).setBackgroundColor(Color.GRAY);
                if (save != -1 && save != i){
                    adapterView.getChildAt(save).setBackgroundColor(Color.WHITE);
                }
                save = i;
                String checkdapan = ((TextView) view.findViewById(R.id.checkDapan)).getText().toString();
                luuDapAn[pos]= Integer.parseInt(checkdapan);
                sttDapAn[pos] = i;
                tvDaLam.setText(CauDaLam+"");
               // Toast.makeText(lamdethi.this, ""+ sttDapAn[pos], Toast.LENGTH_SHORT).show();

                switch (pos){
                    case 0:{
                        btnCau1.setBackgroundColor(Color.GREEN);

                        break;
                    }
                    case 1:{
                        btnCau2.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 2:{
                        btnCau3.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 3:{
                        btnCau4.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 4:{
                        btnCau5.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 5:{
                        btnCau6.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 6:{
                        btnCau7.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 7:{
                        btnCau8.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 8:{
                        btnCau9.setBackgroundColor(Color.GREEN);
                        break;
                    }
                    case 9:{
                        btnCau10.setBackgroundColor(Color.GREEN);
                        break;
                    }
                }

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
        checkdapan = findViewById(R.id.checkDapan);
        tvDaLam = findViewById(R.id.dalam);
        hinhCauHoi = findViewById(R.id.HinhCauHoi);
        lvCausai = findViewById(R.id.lvCauSai);
        btnCau1 = findViewById(R.id.btnCau1);
        btnCau2 = findViewById(R.id.btnCau2);
        btnCau3 = findViewById(R.id.btnCau3);
        btnCau4 = findViewById(R.id.btnCau4);
        btnCau5 = findViewById(R.id.btnCau5);
        btnCau6 = findViewById(R.id.btnCau6);
        btnCau7 = findViewById(R.id.btnCau7);
        btnCau8 = findViewById(R.id.btnCau8);
        btnCau9 = findViewById(R.id.btnCau9);
        btnCau10 = findViewById(R.id.btnCau10);
        tvTimeout = findViewById(R.id.tvTimeout);

    }
}