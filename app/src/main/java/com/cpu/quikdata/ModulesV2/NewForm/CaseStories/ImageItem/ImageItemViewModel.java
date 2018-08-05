package com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICameraSourceViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ICaseStoriesFragment;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import com.cpu.quikdata.BR;

public class ImageItemViewModel extends BaseViewModel<INewFormActivity> implements IBaseDataManager<String> {

    private String mImagePath;
    private int mItemIndex;
    private ICameraSourceViewModel mDataManager;

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
        mDataManager = dataManager;
        mDataManager.getImagePathAtIndex(this, mItemIndex);
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

    /**
     * Handles navigation when delete button is pressed
     */
    public boolean navigateOnDeleteButtonPressed() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mViewComponent.get().onItemDeleteButtonPressed(mItemIndex);
        }
        return true;
    }

    /**
     * Handles navigation when item is pressed
     */
    public void navigateOnItemPressed() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mViewComponent.get().onItemOpened(mImagePath);
        }
    }
}
