package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model;

public class DialogItemModelBoolean extends DialogItemModel {

    private boolean value1;

    public DialogItemModelBoolean(String text, boolean value1) {
        super(text);
        this.value1 = value1;
    }

    public boolean getValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }
}
