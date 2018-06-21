package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model;

public abstract class DialogItemModel {

    private String text;

    public DialogItemModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
