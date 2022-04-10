package com.example.onblx;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
            BienBaoModels bienBaoModels = new BienBaoModels(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getBlob(4));
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
}
