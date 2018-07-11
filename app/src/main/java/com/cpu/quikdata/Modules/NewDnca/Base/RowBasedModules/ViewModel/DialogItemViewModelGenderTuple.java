package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.databinding.ObservableInt;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

public class DialogItemViewModelGenderTuple extends DialogItemViewModel {

    public final ObservableInt value1 = new ObservableInt(0);
    public final ObservableInt value2 = new ObservableInt(0);

    public DialogItemViewModelGenderTuple(DialogItemModelGenderTuple model) {
        text.set(model.getText());
        value1.set(model.getValue1());
        value2.set(model.getValue2());
    }

    public DialogItemViewModelGenderTuple(QuestionModel model) {
        text.set(model.getQuestion());
        value1.set(model.getValue1());
        value2.set(model.getValue2());
    }
}
