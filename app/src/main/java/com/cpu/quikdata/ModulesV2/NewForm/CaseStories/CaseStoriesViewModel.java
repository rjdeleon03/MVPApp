package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.CaseStories.CaseStories;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.CaseStories.ImageItem.ImageItemAdapter;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import com.cpu.quikdata.BR;

import java.util.List;

import io.realm.RealmList;

public class CaseStoriesViewModel extends BaseViewModel<INewFormActivity> implements IBaseDataManager<CaseStories>, ICameraSourceViewModel {

    private CaseStories mCaseStories;
    private RealmList<String> mImagePaths;
    private ImageItemAdapter mImageAdapter;

    public final ObservableField<String> mStoriesText = new ObservableField<>("");

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CaseStoriesViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getCaseStories(this);
    }

    @Override
    public void setViewComponent(INewFormActivity viewComponent) {
        super.setViewComponent(viewComponent);
        mImageAdapter = new ImageItemAdapter(mViewComponent.get(), this);
    }

    /**
     * Handles reception of case stories data
     * @param data
     */
    @Override
    public void onDataReceived(CaseStories data) {
        mCaseStories = data;
        mImagePaths = mCaseStories.getImagePaths();
        mStoriesText.set(mCaseStories.getStoriesText());
    }

    /**
     * Handles navigation when add image button is pressed
     */
    public void navigateOnAddImageButtonPressed() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            if (mImagePaths.size() >= AppConstants.MAX_IMAGE_COUNT) {
                mViewComponent.get().displayToastMessage("A maximum of 6 images may be added.", Toast.LENGTH_LONG);
            } else {
                mViewComponent.get().onCaseStoriesAddImageButtonPressed(this, AppConstants.MAX_IMAGE_COUNT - mImagePaths.size());
            }
        }
    }

    /**
     * Retrieves the image item adapter
     * @return
     */
    @Bindable
    public ImageItemAdapter getImageItemAdapter() {
        return mImageAdapter;
    }

    /**
     * Retrieves the image paths
     * @return
     */
    @Bindable
    public RealmList<String> getImagePaths() {
        return mImagePaths;
    }

    /**
     * Handle loading of images
     * @param imagePaths
     */
    @Override
    public void onImagesLoaded(List<String> imagePaths) {
        mImagePaths.addAll(imagePaths);
        notifyPropertyChanged(BR.imagePaths);
    }

    /**
     * Retrieves image path at specified index
     * @param callback
     * @param index
     */
    @Override
    public void getImagePathAtIndex(IBaseDataManager<String> callback, int index) {
        callback.onDataReceived(mImagePaths.get(index));
    }

    /**
     * Gets the number of image paths
     * @return
     */
    @Override
    public int getImageItemsCount() {
        return mImagePaths.size();
    }

    /**
     * Deletes the image at the specified index
     * @param index
     */
    @Override
    public void deleteImagePathAtIndex(int index) {
        mImagePaths.remove(index);
        notifyPropertyChanged(BR.imagePaths);
    }

    /**
     * Save data when view is paused
     */
    public void onViewPaused() {
        mCaseStories.setStoriesText(mStoriesText.get());
    }
}
