package com.example.onblx;

public class BienBaoModels {
    private byte[] imgBienbao;
    private String maBienBao, tenBienBao, yNghiaBienBao;

    public BienBaoModels() {
    }

    public BienBaoModels(byte[] imgBienbao, String maBienBao, String tenBienBao, String yNghiaBienBao) {
        this.imgBienbao = imgBienbao;
        this.maBienBao = maBienBao;
        this.tenBienBao = tenBienBao;
        this.yNghiaBienBao = yNghiaBienBao;
    }

    public byte[] getImgBienbao() {
        return imgBienbao;
    }

    public void setImgBienbao(byte[] imgBienbao) {
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
}
