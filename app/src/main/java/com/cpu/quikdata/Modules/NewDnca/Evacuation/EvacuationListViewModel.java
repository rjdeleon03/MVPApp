package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;
import com.cpu.quikdata.Modules.NewDnca.NewDncaNavigator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class EvacuationListViewModel extends BaseMultiPageViewModel implements EvacuationRepositoryManager {

    public ObservableList<EvacuationInfo> evacuationList;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public EvacuationListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        evacuationList = new ObservableArrayList<>();
        evacuationList.addAll(mDncaForm.getEvacuationInfos());
    }

    /**
     * Gets all evacuation info items
     * @return
     */
    @Override
    public List<EvacuationInfo> getEvacuationInfos() {
        return evacuationList;
    }

    /**
     * Gets evacuation info at specified index
     * @param index
     * @return
     */
    @Override
    public EvacuationInfo getEvacuationInfo(int index) {
        return evacuationList.get(index);
    }

    /**
     * Saves evacuation infos
     * @param evacuationInfos
     */
    @Override
    public void saveEvacuationInfos(List<EvacuationInfo> evacuationInfos) {
        evacuationList.clear();
        evacuationList.addAll(evacuationInfos);
        mDncaForm.setEvacuationInfo(evacuationList);
    }

    /**
     * Saves evacuation info at specified index
     * @param evacuationInfo
     * @param index
     */
    @Override
    public void saveEvacuationInfo(EvacuationInfo evacuationInfo, int index) {
        if (index > -1) {
            evacuationList.set(index, evacuationInfo);
        } else {
            evacuationList.add(evacuationInfo);
        }
    }

    /**
     * Handles navigation when evacuation add button is pressed
     */
    public void navigateOnEvacuationAddButtonPressed() {
        mNewDncaNavigator.onEvacuationAddButtonPressed();
    }
}
