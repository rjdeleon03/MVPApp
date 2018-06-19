package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;

public class DialogItemViewModelSingleNumber extends DialogItemViewModel {

    public final ObservableInt value1 = new ObservableInt(0);

    public DialogItemViewModelSingleNumber(DialogItemModelSingleNumber model) {
        text.set(model.getText());
        value1.set(model.getValue1());
    }
}
