package com.example.onblx;

import java.sql.Blob;

public class CauHoi {
    private int MaCauHoi,MaLoaiCauHoi;
    private String NoiDung;
    private byte[] HinhBienBao;

    public CauHoi(int anInt, String string, int cursorInt, byte[] blob) {
    }

    public CauHoi(int maCauHoi, int maLoaiCauHoi, String noiDung, byte[] hinhBienBao) {
        MaCauHoi = maCauHoi;
        MaLoaiCauHoi = maLoaiCauHoi;
        NoiDung = noiDung;
        HinhBienBao = hinhBienBao;
    }

    public int getMaCauHoi() {
        return MaCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        MaCauHoi = maCauHoi;
    }

    public int getMaLoaiCauHoi() {
        return MaLoaiCauHoi;
    }

    public void setMaLoaiCauHoi(int maLoaiCauHoi) {
        MaLoaiCauHoi = maLoaiCauHoi;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public byte[] getHinhBienBao() {
        return HinhBienBao;
    }

    public void setHinhBienBao(byte[] hinhBienBao) {
        HinhBienBao = hinhBienBao;
    }
}
