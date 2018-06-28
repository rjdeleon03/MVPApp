package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;

public class EvacuationListItemViewModel {

    public final ObservableField<String> head = new ObservableField<>("");
    public final ObservableField<String> text = new ObservableField<>("");

    public EvacuationListItemViewModel(EvacuationInfo evacuationInfo) {
        head.set(evacuationInfo.getSiteData().getName());
        text.set(evacuationInfo.getSiteData().getLocation());
    }
}
