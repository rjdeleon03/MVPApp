package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;

public class DialogItemViewModelRemarks extends DialogItemViewModel {

    public final ObservableField<String> note = new ObservableField<>("");
    public final ObservableField<String> value1 = new ObservableField<>("");

    public DialogItemViewModelRemarks(DialogItemModelRemarks model) {
        text.set(model.getText());
        note.set(model.getNote());
        value1.set(model.getValue1());
    }
}
