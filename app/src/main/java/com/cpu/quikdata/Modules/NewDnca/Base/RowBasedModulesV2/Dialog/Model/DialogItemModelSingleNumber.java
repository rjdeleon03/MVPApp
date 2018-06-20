package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model;

public class DialogItemModelSingleNumber extends DialogItemModel {

    private int value1;
    private boolean displayAsMultLines;

    public DialogItemModelSingleNumber(String text, int value1, boolean displayAsMultLines) {
        super(text);
        this.value1 = value1;
        this.displayAsMultLines = displayAsMultLines;
    }

    public DialogItemModelSingleNumber(String text, int value1) {
        this(text, value1, false);
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public boolean willDisplayAsMultLines() {
        return displayAsMultLines;
    }

    public void setDisplayAsMultLines(boolean displayAsMultLines) {
        this.displayAsMultLines = displayAsMultLines;
    }
}
