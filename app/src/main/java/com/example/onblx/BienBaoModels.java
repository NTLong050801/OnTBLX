package com.example.onblx;

import android.widget.ImageView;

public class BienBaoModels {
//    private byte[] imgBienbao;
    public String maBienBao, tenBienBao, yNghiaBienBao;
    public ImageView imgBienBao;
    public BienBaoModels() {
    }

    public BienBaoModels(String maBienBao, String tenBienBao, String yNghiaBienBao, ImageView imgBienBao) {
        this.maBienBao = maBienBao;
        this.tenBienBao = tenBienBao;
        this.yNghiaBienBao = yNghiaBienBao;
        this.imgBienBao = imgBienBao;
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

    public ImageView getImgBienBao() {
        return imgBienBao;
    }

    public void setImgBienBao(ImageView imgBienBao) {
        this.imgBienBao = imgBienBao;
    }
}
