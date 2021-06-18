package com.company.Model;

import java.util.List;

public class LoaiPhong {
    private int MALOAIPHONG;
    private String TENLOAIPHONG;
    private double GIA; 
    private int SOLUONG;

    LoaiPhong(){}
    public LoaiPhong(int mlp, String tenlp, double gia, int soluong){
        this.MALOAIPHONG = mlp;
        this.TENLOAIPHONG = tenlp;
        this.GIA = gia;
        this.SOLUONG = soluong;
    }

    public void setMALOAIPHONG(int MALOAIPHONG) {
        this.MALOAIPHONG = MALOAIPHONG;
    }

    public int getMALOAIPHONG() {
        return MALOAIPHONG;
    }

    public void setTENLOAIPHONG(String TENLOAIPHONG) {
        this.TENLOAIPHONG = TENLOAIPHONG;
    }

    public String getTENLOAIPHONG() {
        return TENLOAIPHONG;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public double getGIA() {
        return GIA;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }
}
