package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelBoolean;

public class DialogItemViewModelBoolean extends DialogItemViewModel {

    public final ObservableBoolean value1 = new ObservableBoolean(false);

    public DialogItemViewModelBoolean(DialogItemModelBoolean model) {
        text.set(model.getText());
        value1.set(model.getValue1());
    }
}
