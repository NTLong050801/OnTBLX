package com.example.onblx;

public class GroupCauHoi {
    private String title,noidung,Socauhoi, Socaulam;


    public GroupCauHoi(String title, String noidung, String socauhoi, String socaulam) {
        this.title = title;
        this.noidung = noidung;
        Socauhoi = socauhoi;
        Socaulam = socaulam;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getSocauhoi() {
        return Socauhoi;
    }

    public void setSocauhoi(String socauhoi) {
        Socauhoi = socauhoi;
    }

    public String getSocaulam() {
        return Socaulam;
    }

    public void setSocaulam(String socaulam) {
        Socaulam = socaulam;
    }
}
