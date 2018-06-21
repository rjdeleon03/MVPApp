package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelDivider;

public class DialogItemViewModelDivider extends DialogItemViewModel {

    public final ObservableBoolean hideLine = new ObservableBoolean(false);

    public DialogItemViewModelDivider(DialogItemModelDivider model) {
        text.set(model.getText());
        hideLine.set(model.willHideLine());
    }
}
