package com.example.onblx;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import database.DataBase;

public class Model {
    DataBase database;
    SQLiteDatabase sqLiteDatabase;


    public Model(Context context) {
        database = new DataBase(context);
    }

    public void OpenConnect() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    public void CloseConnect() {
        database.close();
    }


    public ArrayList<CauHoi> getData() {
        OpenConnect();
        ArrayList<CauHoi> listCauHoi = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BienBao", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CauHoi cauhoi = new CauHoi(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getBlob(3));
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        CloseConnect();
        return listCauHoi;
    }

    public ArrayList<BienBaoModels> getBienBaoCam(String sql) {
        OpenConnect();
        ArrayList<BienBaoModels> listBienBao = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            BienBaoModels bienBaoModels = new BienBaoModels(cursor.getString(0), cursor.getString(1), cursor.getString(4), cursor.getBlob(3));
            listBienBao.add(bienBaoModels);
            cursor.moveToNext();
        }
        CloseConnect();
        return listBienBao;
    }
    public ArrayList<CauHoi> get_cauHoi(String sql) {
        OpenConnect();
        ArrayList<CauHoi> listCauHoi = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CauHoi cauhoi = new CauHoi(cursor.getInt(0),cursor.getInt(2),cursor.getString(1),cursor.getBlob(3));
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        CloseConnect();
        return listCauHoi;
    }
    public ArrayList<DapAn> get_dapAn(String sql) {
        OpenConnect();
        ArrayList<DapAn> listDapAn = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DapAn dapan = new DapAn(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3));
            listDapAn.add(dapan);
            cursor.moveToNext();
        }
        CloseConnect();
        return listDapAn;
    }
    public ArrayList<BienBaoModels> getChiTietBienBao(String sql) {
        OpenConnect();
        ArrayList<BienBaoModels> listBienBao = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            BienBaoModels bienBaoModels = new BienBaoModels(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(3));
            listBienBao.add(bienBaoModels);
            cursor.moveToNext();
        }
        CloseConnect();
        return listBienBao;
    }

    //Câu sai

    public Integer TongCauSai(){
        OpenConnect();
        String sql_check = "SELECT Count(MaCauSai) from CauSai ";
        int dem;
        try {
            Cursor cursor = sqLiteDatabase.rawQuery(sql_check,null);
            cursor.moveToFirst();
            dem =  cursor.getInt(0);
        }catch (Exception e){
                dem = 0;
        }
        return  dem;
    }

    public Integer Check_cauSai (Integer MaCauHoi){
        OpenConnect();
        String sql_check = "SELECT Count(MaCauSai) from CauSai where MaCauSai = "+MaCauHoi+"";
        Integer dem;
        try {
            Cursor cursor = sqLiteDatabase.rawQuery(sql_check,null);
            cursor.moveToFirst();
            dem =  cursor.getInt(0);
        }catch (Exception e){
            dem = 0;
        }
        return  dem;

    }
    public  void Insert_cauSai(Integer MaCauHoi){
        OpenConnect();
        Integer dem = Check_cauSai(MaCauHoi);
        if(dem == 0){
            String sql_insert = "INSERT INTO CauSai(MaCauSai) values ("+MaCauHoi+")";
            sqLiteDatabase.execSQL(sql_insert);
        }


    }
    // trả về danh sách mảng các đối tượng câu hỏi sai
    public ArrayList<CauHoi> get_cauHoiSai() {
        OpenConnect();
        ArrayList<Integer> listCauSai1 = listCauSai();
        ArrayList<CauHoi> list = new ArrayList<>();
            for(int i = 0 ; i< listCauSai1.size();i++){
                Integer ma = listCauSai1.get(i).intValue();
                String sql1 = "SELECT  * from CauHoi where MaCauHoi =  " + ma+"";
                Cursor cursor = sqLiteDatabase.rawQuery(sql1, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    CauHoi cauhoi = new CauHoi(cursor.getInt(0),cursor.getInt(2),cursor.getString(1),cursor.getBlob(3));
                    list.add(cauhoi);
                    cursor.moveToNext();
                }
            }
        return list;
    }
    // danh sách mảng các mã câu hỏi bị sai
    public ArrayList<Integer> listCauSai(){
        ArrayList<Integer> listCauSai = new ArrayList<>();
        if(TongCauSai() > 0){
            String sql = "SELECT * from CauSai";
            Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Integer Macausai = cursor.getInt(0);
                listCauSai.add(Macausai);
                cursor.moveToNext();
            }
        }
        return listCauSai;
    }

    //Xóa all câu sai
    public void delete_all(){
        String sql = "DELETE  from CauSai";
        sqLiteDatabase.execSQL(sql);
    }
    public void delete_item(Integer MaCauSai){
        OpenConnect();
        String sql1 = "DELETE  from CauSai where MaCauSai = "+MaCauSai+"";
        sqLiteDatabase.execSQL(sql1);
    }

}
