package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model;

import com.cpu.quikdata.Models.Generics.SimpleDate;

public class DialogItemModelDate extends DialogItemModel {

    private SimpleDate value1;

    public DialogItemModelDate(String text, SimpleDate value1) {
        super(text);
        this.value1 = value1;
    }

    public SimpleDate getValue1() {
        return value1;
    }

    public void setValue1(SimpleDate value1) {
        this.value1 = value1;
    }
}
