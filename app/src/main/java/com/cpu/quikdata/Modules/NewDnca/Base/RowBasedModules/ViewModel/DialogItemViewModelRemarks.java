package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.databinding.ObservableField;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;

public class DialogItemViewModelRemarks extends DialogItemViewModel {

    public final ObservableField<String> note = new ObservableField<>("");
    public final ObservableField<String> value1 = new ObservableField<>("");

    public DialogItemViewModelRemarks(DialogItemModelRemarks model) {
        text.set(model.getText());
        note.set(model.getNote());
        value1.set(model.getValue1());
    }
}
