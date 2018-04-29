package com.rjdeleon.mvp_app.Models.Generics;

public class SimpleDate {
    private int year;
    private int month;
    private int dayOfMonth;

    public SimpleDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Override
    public String toString() {
        return year + "/" + (month+1) + "/" + dayOfMonth;
    }

    public void setFromString(String dateString) {
        String[] arr = dateString.split("/");
        year = Integer.parseInt(arr[0]);
        month = Integer.parseInt(arr[1]) - 1;
        dayOfMonth = Integer.parseInt(arr[2]);
    }
}
