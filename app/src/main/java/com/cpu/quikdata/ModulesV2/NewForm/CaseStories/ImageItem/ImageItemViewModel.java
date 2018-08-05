package com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICameraSourceViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICaseStoriesFragment;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import com.cpu.quikdata.BR;

public class ImageItemViewModel extends BaseViewModel<ICaseStoriesFragment> implements IBaseDataManager<String> {

    private String mImagePath;
    private int mItemIndex;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param index
     */
    public ImageItemViewModel(DNCAFormRepository dncaFormRepository, int index) {
        super(dncaFormRepository);
        mItemIndex = index;
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(ICameraSourceViewModel dataManager) {
        dataManager.getImagePathAtIndex(this, mItemIndex);
    }

    /**
     * Handles the reception of image path
     * @param data
     */
    @Override
    public void onDataReceived(String data) {
        mImagePath = data;
        notifyPropertyChanged(BR.imagePath);
    }

    /**
     * Retrieves the image path
     * @return
     */
    @Bindable
    public String getImagePath() {
        return mImagePath;
    }
}
