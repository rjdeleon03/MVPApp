package com.rjdeleon.mvp_app.Models.Generics;

public class GenderTuple {
    public int male;
    public int female;

    public GenderTuple(int male, int female) {
        this.male = male;
        this.female = female;
    }

    public GenderTuple() {
        this(0, 0);
    }
}
