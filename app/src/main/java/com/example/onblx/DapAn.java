package com.example.onblx;

public class DapAn {
    private int MaDapAn,MaCauHoi;
    private  String NoiDung;
    private int DapAnDung;


    public DapAn(int maDapAn, int maCauHoi, String noiDung, int dapAnDung) {
        MaDapAn = maDapAn;
        MaCauHoi = maCauHoi;
        NoiDung = noiDung;
        DapAnDung = dapAnDung;
    }

    public int getMaDapAn() {
        return MaDapAn;
    }

    public void setMaDapAn(int maDapAn) {
        MaDapAn = maDapAn;
    }

    public int getMaCauHoi() {
        return MaCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        MaCauHoi = maCauHoi;
    }

    public int getDapAnDung() {
        return DapAnDung;
    }

    public void setDapAnDung(int dapAnDung) {
        DapAnDung = dapAnDung;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }
}
