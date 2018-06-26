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

    private List<EvacuationInfo> mEvacuationList;

    @Nullable
    private WeakReference<NewDncaNavigator> mNavigator;


    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public EvacuationListViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }

    /**
     * Sets the navigator
     * @param navigator
     */
    public void setNavigator(NewDncaNavigator navigator) {
        mNavigator = new WeakReference<>(navigator);
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        mEvacuationList = new ArrayList<>(mDncaForm.getEvacuationInfos());
    }

    /**
     * Gets all evacuation info items
     * @return
     */
    @Override
    public List<EvacuationInfo> getEvacuationInfos() {
        return mEvacuationList;
    }

    /**
     * Gets evacuation info at specified index
     * @param index
     * @return
     */
    @Override
    public EvacuationInfo getEvacuationInfo(int index) {
        return mEvacuationList.get(index);
    }

    /**
     * Saves evacuation infos
     * @param evacuationInfos
     */
    @Override
    public void saveEvacuationInfos(List<EvacuationInfo> evacuationInfos) {
        mEvacuationList = evacuationInfos;
        mDncaForm.setEvacuationInfo(mEvacuationList);
    }

    /**
     * Saves evacuation info at specified index
     * @param index
     */
    @Override
    public void saveEvacuationInfo(int index) {

    }

    /**
     * Handles navigation when evacuation add button is pressed
     */
    public void navigateOnEvacuationAddButtonPressed() {
        mNavigator.get().onEvacuationAddButtonPressed();
    }
}
