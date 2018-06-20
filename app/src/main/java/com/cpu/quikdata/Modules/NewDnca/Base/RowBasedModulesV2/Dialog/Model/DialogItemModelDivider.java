package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model;

public class DialogItemModelDivider extends DialogItemModel {

    private boolean hideLine;

    public DialogItemModelDivider(String text, boolean hideLine) {
        super(text);
        this.hideLine = hideLine;
    }

    public boolean willHideLine() {
        return hideLine;
    }

    public void setHideLine(boolean hideLine) {
        this.hideLine = hideLine;
    }
}
