package com.cpu.quikdata.Models.Generics;

public class BoolRemarksTuple {
    public boolean isYes;
    public String remarks;

    public BoolRemarksTuple(boolean isYes, String remarks) {
        this.isYes = isYes;
        this.remarks = remarks;
    }

    public BoolRemarksTuple() {
        this(false, "");
    }
}
