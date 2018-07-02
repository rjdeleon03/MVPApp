package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;

public class EvacuationListItemViewModel {

    public final ObservableField<String> head = new ObservableField<>("");
    public final ObservableField<String> text = new ObservableField<>("");

    private EvacuationRepositoryManager mRepositoryManager;
    private int mItemIndex;

    public EvacuationListItemViewModel(EvacuationRepositoryManager repositoryManager, int index) {
        mRepositoryManager = repositoryManager;
        mItemIndex = index;

        EvacuationInfo evacuationInfo = mRepositoryManager.getEvacuationInfo(mItemIndex);
        head.set(evacuationInfo.getSiteData().getName());
        text.set(evacuationInfo.getSiteData().getLocation());
    }

    public void navigateOnEvacuationItemPressed() {
        mRepositoryManager.navigateOnEvacuationItemPressed(mItemIndex);
    }

    public void navigateOnEvacuationItemDeletePressed() {
        mRepositoryManager.navigateOnEvacuationItemDeletePressed(mItemIndex);
    }
}
