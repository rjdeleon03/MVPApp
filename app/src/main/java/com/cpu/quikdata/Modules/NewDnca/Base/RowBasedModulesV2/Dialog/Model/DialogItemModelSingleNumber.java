package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model;

public class DialogItemModelSingleNumber extends DialogItemModel {

    private int value1;

    public DialogItemModelSingleNumber(String text, int value1) {
        super(text);
        this.value1 = value1;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }
}
