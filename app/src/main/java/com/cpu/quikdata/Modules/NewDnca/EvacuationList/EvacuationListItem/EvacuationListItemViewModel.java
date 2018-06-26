package com.cpu.quikdata.Modules.NewDnca.EvacuationList.EvacuationListItem;

import android.content.Context;
import android.databinding.ObservableField;

public class EvacuationListItemViewModel {

    public final ObservableField<String> head = new ObservableField<>("");
    public final ObservableField<String> text = new ObservableField<>("");

    public EvacuationListItemViewModel(Context context) {
        head.set("SOME TITLE");
        text.set("SOME TEXT");
    }
}
