package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model;

public class DialogItemModelRemarks extends DialogItemModel {

    private String note;
    private String value1;

    public DialogItemModelRemarks(String text, String note, String value1) {
        super(text);
        this.note = note;
        this.value1 = value1;
    }

    public DialogItemModelRemarks(String text, String value1) {
        this(text, "", value1);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
}
