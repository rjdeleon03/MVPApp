package com.rjdeleon.mvp_app.Models;

public class GenderTuple {
    private int male;
    private int female;

    public GenderTuple(int male, int female) {
        this.male = male;
        this.female = female;
    }

    public int getMale() {
        return male;
    }

    public int getFemale() {
        return female;
    }
}
