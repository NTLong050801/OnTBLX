package com.example.onblx;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import adapter.DapAnAdapter;
import database.DataBase;

public class dengaunhien extends AppCompatActivity {
    TextView titleDeThi,tvDaLam,CauhoiDethi,checkdapan,tvTimeout;
    Boolean counterIsactive1 = false;
    ImageView hinhCauHoi;
    Button btnend,btnCau1,btnCau2,btnCau3,btnCau4,btnCau5,btnCau6,btnCau7,btnCau8,btnCau9,btnCau10;
    ListView lvDapAnDeThi;
    ImageButton imgnext,imgback;
    CountDownTimer countDownTimer1;
    private  boolean checkDiemLiet = true;
    private int pos = 0,CauDaLam = 0,stt_dung;
    private  int[] listRandom;
    private ArrayList<Integer> listCauhoiDe;
    private  int[] luuDapAn = new int[] {2,2,2,2,2,2,2,2,2,2};
    private  int[] sttDapAn = new int[] {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
    private DataBase dataBase = new DataBase(this);
    ArrayList<CauHoi> listCauhoi = new ArrayList<>();
    ArrayList<DapAn> dapAnArrayList ;
    ArrayList<Integer> listCauLiet = new ArrayList<>();
    DapAnAdapter dapAnAdapter;
    Model model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamdethi);
        anhxa();
        model = new Model(this);
        titleDeThi.setText("Đề Random");
        listCauhoiDe = new ArrayList<>();
        listRandom = new int[10];
        Random random = new Random();
        ArrayList<Integer> listRandom = new ArrayList<>();
        // add 10 câu random vào ListRandom
        for(int i = 0; i<10; i++){
            int number = random.nextInt(30)+1;
            listRandom.add(number);
        }
        // add 10 câu hỏi vào Arr<CauHoi> listCauhoi
        for (int i = 0 ; i<listRandom.size();i++){
            String sql = "SELECT * from CauHoi where MaCauHoi = "+listRandom.get(i)+"";
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

        //counterIsactive1 = false
        if(counterIsactive1){

        }else {
            counterIsactive1 = true;
            // khởi tạo countDownTime = 3p
            countDownTimer1 = new CountDownTimer(180000,1000) {
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
                            setBackgr(a,Color.GREEN);
                        }
                        if(luuDapAn[a] != 1){
                            setBackgr(a,Color.RED);
                            if(listRandom.get(a) == 9 || listRandom.get(a) == 12 || listRandom.get(a) == 13 ||listRandom.get(a) == 14 || listRandom.get(a) == 15 ){
                                checkDiemLiet = false;
                                listCauLiet.add(a);
                            }
                            model.Insert_cauSai(listRandom.get(a));
                        }
                    }
                    if(checkDiemLiet){
                        AlertDialog.Builder thongbaodiem = new AlertDialog.Builder(dengaunhien.this);
                        thongbaodiem.setTitle("Hết giờ !!!");
                        thongbaodiem.setMessage("Bạn đúng "+sodapandung +"/10");
                        thongbaodiem.setIcon(R.drawable.ic_checked);
                        thongbaodiem.setNegativeButton("Làm đề khác", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                startActivity(getIntent());
                            }
                        });
                        thongbaodiem.show();
                    }else {
                        DiaLogLiet(listCauLiet);
                    }
                    btnend.setText("Đã Nộp");
                    btnend.setEnabled(false);
                    btnend.setBackgroundColor(Color.GREEN);
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
                AlertDialog.Builder dialog = new AlertDialog.Builder(dengaunhien.this);
                dialog.setTitle("Thông báo");
                dialog.setMessage("Bạn chắc chắn nộp bài ?");
                dialog.setIcon(R.drawable.img);
                dialog.setPositiveButton("Nộp", new DialogInterface.OnClickListener() {
                    int sodapandung = 0;
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        counterIsactive1 = false;
                        countDownTimer1.cancel();
                        for(int a = 0 ; a< luuDapAn.length;a++){
                            if(luuDapAn[a] == 1){
                                sodapandung++;
                                setBackgr(a,Color.GREEN);
                            }
                            else{
                                setBackgr(a,Color.RED);
                                if(listRandom.get(a) == 9 || listRandom.get(a) == 12 || listRandom.get(a) == 13 ||listRandom.get(a) == 14 || listRandom.get(a) == 15 ){
                                    checkDiemLiet = false;
                                    listCauLiet.add(a+1);
                                }
                                model.Insert_cauSai(listRandom.get(a));
                            }
                        }
                        if(checkDiemLiet){
                            AlertDialog.Builder thongbaodiem = new AlertDialog.Builder(dengaunhien.this);
                            thongbaodiem.setTitle("Nộp bài thành công");
                            thongbaodiem.setMessage("Bạn đúng "+sodapandung +"/10");
                            thongbaodiem.setIcon(R.drawable.ic_checked);

                            thongbaodiem.setNegativeButton("Làm đề random khác", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            thongbaodiem.show();
                        }else {
                            DiaLogLiet(listCauLiet);
                        }
                        btnend.setText("Đã Nộp");
                        btnend.setEnabled(false);
                        btnend.setBackgroundColor(Color.GREEN);
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
        dapAnArrayList = new ArrayList<>();
        CauHoi cauHoi_get = listCauhoi.get(pos);

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
            dapAnArrayList.add(dapAn);
        }
        dapAnAdapter = new DapAnAdapter(dengaunhien.this,R.layout.item_dapan,dapAnArrayList){
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view1 = super.getView(i, view, viewGroup);
                int dem = -1;
                for (DapAn dapAn_dung : dapAnArrayList) {
                    dem++;
                    if (dapAn_dung.getDapAnDung() == 1) {
                        stt_dung = dem;
                    }
                }
                if(i == sttDapAn[pos]){
                    view1.setBackgroundColor(Color.GRAY);
                }else if(btnend.getText() == "Đã Nộp") {
                    if(i == (stt_dung)){
                        view1.setBackgroundColor(Color.GREEN);
                    }
                }
                return view1;
            }
        };
        lvDapAnDeThi.setAdapter(dapAnAdapter);


    }
    private void DiaLogLiet(ArrayList<Integer> sttCauLiet){

        AlertDialog.Builder checkliet = new AlertDialog.Builder(dengaunhien.this);
        checkliet.setTitle("SAI CÂU ĐIỂM LIỆT");
        String strDiemLiet = "";
        for(int i =0 ; i< sttCauLiet.size();i++){
            strDiemLiet += ""+ (sttCauLiet.get(i))+",";
        }
        strDiemLiet = strDiemLiet.substring(0, strDiemLiet.length() - 1);
        checkliet.setMessage("Bạn trượt ... vì câu " +strDiemLiet + " là câu liệt");
        checkliet.setIcon(R.drawable.ic_checked);
        checkliet.setNegativeButton("Làm lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                startActivity(getIntent());
            }
        });
        checkliet.show();
    }
    private  void chondapan(){

        lvDapAnDeThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(sttDapAn[pos] == -2){
                    CauDaLam = CauDaLam+1;
                }

                for (int j = 0 ; j< dapAnAdapter.getCount();j++){
                    if(i == j){
                        adapterView.getChildAt(i).setBackgroundColor(Color.GRAY);
                    }else {
                        adapterView.getChildAt(j).setBackgroundColor(Color.WHITE);
                    }
                }
                String checkdapan = ((TextView) view.findViewById(R.id.checkDapan)).getText().toString();
                luuDapAn[pos]= Integer.parseInt(checkdapan);
                sttDapAn[pos] = i;
                tvDaLam.setText(CauDaLam+"");
                setBackgr(pos,Color.CYAN);
               // Toast.makeText(dengaunhien.this, ""+dapAnAdapter.getCount(), Toast.LENGTH_SHORT).show();
            }

        });
    }
    private void setBackgr(Integer Vitri , int color){

        switch (Vitri){
            case 0:{
                btnCau1.setBackgroundColor(color);

                break;
            }
            case 1:{
                btnCau2.setBackgroundColor(color);
                break;
            }
            case 2:{
                btnCau3.setBackgroundColor(color);
                break;
            }
            case 3:{
                btnCau4.setBackgroundColor(color);
                break;
            }
            case 4:{
                btnCau5.setBackgroundColor(color);
                break;
            }
            case 5:{
                btnCau6.setBackgroundColor(color);
                break;
            }
            case 6:{
                btnCau7.setBackgroundColor(color);
                break;
            }
            case 7:{
                btnCau8.setBackgroundColor(color);
                break;
            }
            case 8:{
                btnCau9.setBackgroundColor(color);
                break;
            }
            case 9:{
                btnCau10.setBackgroundColor(color);
                break;
            }
        }
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
