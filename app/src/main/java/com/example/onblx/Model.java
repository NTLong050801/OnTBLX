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
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM CauHoi", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            CauHoi cauhoi = new CauHoi(cursor.getInt(0),cursor.getInt(1) ,cursor.getString(2),cursor.getBlob(3));
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        CloseConnect();
        return listCauHoi;
    }


}
