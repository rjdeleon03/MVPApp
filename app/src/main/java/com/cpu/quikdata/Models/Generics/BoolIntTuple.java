package com.cpu.quikdata.Models.Generics;

public class BoolIntTuple {

    public boolean isYes;
    public int remarks;

    public BoolIntTuple(boolean isYes, int remarks) {
        this.isYes = isYes;
        this.remarks = remarks;
    }

    public BoolIntTuple() {
        this(false, 0);
    }
}
