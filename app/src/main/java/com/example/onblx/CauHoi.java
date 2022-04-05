package com.example.onblx;

public class CauHoi {
   private String tencauhoi;
   private byte[] hinhanh;

    public CauHoi() {
    }

    public CauHoi(String tencauhoi, byte[] hinhanh) {
        this.tencauhoi = tencauhoi;
        this.hinhanh = hinhanh;
    }

    public String getTencauhoi() {
        return tencauhoi;
    }

    public void setTencauhoi(String tencauhoi) {
        this.tencauhoi = tencauhoi;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }
}
