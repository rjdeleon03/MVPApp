package com.rjdeleon.mvp_app.Models.Generics;

import java.util.Calendar;

public class SimpleDate {
    private int year;
    private int month;
    private int dayOfMonth;

    public SimpleDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public SimpleDate() {
        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
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
