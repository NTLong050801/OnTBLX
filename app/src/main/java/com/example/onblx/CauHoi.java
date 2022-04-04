package com.example.onblx;

public class CauHoi {
   private String tencauhoi;
   private String dapan;
   private byte[] bienbao;

    public CauHoi() {
    }

    public CauHoi(String tencauhoi, String dapan, byte[] bienbao) {
        this.tencauhoi = tencauhoi;
        this.dapan = dapan;
        this.bienbao = bienbao;
    }

    public String getTencauhoi() {
        return tencauhoi;
    }

    public void setTencauhoi(String tencauhoi) {
        this.tencauhoi = tencauhoi;
    }

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }

    public byte[] getBienbao() {
        return bienbao;
    }

    public void setBienbao(byte[] bienbao) {
        this.bienbao = bienbao;
    }
}
