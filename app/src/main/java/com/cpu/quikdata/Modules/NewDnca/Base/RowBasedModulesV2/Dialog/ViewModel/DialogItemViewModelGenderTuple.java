package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;

public class DialogItemViewModelGenderTuple {

    public final ObservableField<String> text = new ObservableField<>("");
    public final ObservableInt value1 = new ObservableInt(0);
    public final ObservableInt value2 = new ObservableInt(0);

    public DialogItemViewModelGenderTuple(DialogItemModelGenderTuple model) {
        text.set(model.getText());
        value1.set(model.getValue1());
        value2.set(model.getValue2());
    }
}
