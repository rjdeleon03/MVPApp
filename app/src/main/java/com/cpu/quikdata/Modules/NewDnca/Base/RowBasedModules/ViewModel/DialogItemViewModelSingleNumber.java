package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;

public class DialogItemViewModelSingleNumber extends DialogItemViewModel {

    public final ObservableInt value1 = new ObservableInt(0);
    public final ObservableBoolean displayAsMultLines = new ObservableBoolean(false);

    public DialogItemViewModelSingleNumber(DialogItemModelSingleNumber model) {
        text.set(model.getText());
        value1.set(model.getValue1());
        displayAsMultLines.set(model.willDisplayAsMultLines());
    }
}
