package com.example.onblx;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

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
            CauHoi cauhoi = new CauHoi(cursor.getString(1), cursor.getBlob(3));
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        CloseConnect();
        return listCauHoi;
    }

    public ArrayList<BienBaoModels> getBienBao() {
        OpenConnect();
        ArrayList<BienBaoModels> listBienBao = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BienBao", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            BienBaoModels bienBaoModels = new BienBaoModels(cursor.getBlob(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            listBienBao.add(bienBaoModels);
            cursor.moveToNext();
        }
        CloseConnect();
        return listBienBao;
    }
}
