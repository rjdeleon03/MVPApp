package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;

public class DialogItemViewModelBoolean extends DialogItemViewModel {

    public final ObservableBoolean value1 = new ObservableBoolean(false);

    public DialogItemViewModelBoolean(DialogItemModelBoolean model) {
        text.set(model.getText());
        value1.set(model.getValue1());
    }
}
