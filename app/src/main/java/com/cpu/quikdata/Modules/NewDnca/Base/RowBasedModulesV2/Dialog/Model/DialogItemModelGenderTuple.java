package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model;

public class DialogItemModelGenderTuple extends DialogItemModel {

    private int value1;
    private int value2;

    public DialogItemModelGenderTuple(String text, int value1, int value2) {
        super(text);
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
