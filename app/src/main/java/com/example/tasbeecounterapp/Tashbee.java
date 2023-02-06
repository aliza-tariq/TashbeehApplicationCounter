package com.example.tasbeecounterapp;

public class Tashbee {

    private String date;
    private int tashbeeh1;
    private int tashbeeh2;
    private int tashbeeh3;
    private int tashbeeh4;


    public Tashbee(String date, int tashbeeh1, int tashbeeh2, int tashbeeh3, int tashbeeh4) {
        this.date = date;
        this.tashbeeh1 = tashbeeh1;
        this.tashbeeh2 = tashbeeh2;
        this.tashbeeh3 = tashbeeh3;
        this.tashbeeh4 = tashbeeh4;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTashbeeh1() {
        return tashbeeh1;
    }

    public void setTashbeeh1(int tashbeeh1) {
        this.tashbeeh1 = tashbeeh1;
    }

    public int getTashbeeh2() {
        return tashbeeh2;
    }

    public void setTashbeeh2(int tashbeeh2) {
        this.tashbeeh2 = tashbeeh2;
    }

    public int getTashbeeh3() {
        return tashbeeh3;
    }

    public void setTashbeeh3(int tashbeeh3) {
        this.tashbeeh3 = tashbeeh3;
    }

    public int getTashbeeh4() {
        return tashbeeh4;
    }

    public void setTashbeeh4(int tashbeeh4) {
        this.tashbeeh4 = tashbeeh4;
    }

    @Override
    public String toString() {
        return "Tashbee{" +
                "date='" + date + '\'' +
                ", tashbeeh1=" + tashbeeh1 +
                ", tashbeeh2=" + tashbeeh2 +
                ", tashbeeh3=" + tashbeeh3 +
                ", tashbeeh4=" + tashbeeh4 +
                '}';
    }
}
