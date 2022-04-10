package com.example.onblx;

import android.widget.ImageView;

public class BienBaoModels {

    public String maBienBao, tenBienBao, yNghiaBienBao;
    private byte[] imgBienbao;

    public BienBaoModels() {
    }

    public BienBaoModels(String maBienBao, String tenBienBao, String yNghiaBienBao, byte[] imgBienbao) {
        this.maBienBao = maBienBao;
        this.tenBienBao = tenBienBao;
        this.yNghiaBienBao = yNghiaBienBao;
        this.imgBienbao = imgBienbao;
    }

    public String getMaBienBao() {
        return maBienBao;
    }

    public void setMaBienBao(String maBienBao) {
        this.maBienBao = maBienBao;
    }

    public String getTenBienBao() {
        return tenBienBao;
    }

    public void setTenBienBao(String tenBienBao) {
        this.tenBienBao = tenBienBao;
    }

    public String getyNghiaBienBao() {
        return yNghiaBienBao;
    }

    public void setyNghiaBienBao(String yNghiaBienBao) {
        this.yNghiaBienBao = yNghiaBienBao;
    }

    public byte[] getImgBienbao() {
        return imgBienbao;
    }

    public void setImgBienbao(byte[] imgBienbao) {
        this.imgBienbao = imgBienbao;
    }
}
