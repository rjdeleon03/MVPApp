package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.CaseStories.CaseStories;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.RealmList;

public class CaseStoriesViewModel extends BaseViewModel<INewFormActivity> implements IBaseDataManager<CaseStories>, ICameraSourceViewModel {

    private CaseStories mCaseStories;
    private RealmList<String> mImagePaths;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CaseStoriesViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getCaseStories(this);
    }

    /**
     * Handles reception of case stories data
     * @param data
     */
    @Override
    public void onDataReceived(CaseStories data) {
        mCaseStories = data;
        mImagePaths = mCaseStories.getImagePaths();
    }

    /**
     * Handles navigation when add image button is pressed
     */
    public void navigateOnAddImageButtonPressed() {
        if (mViewComponent != null && mViewComponent.get() != null) {
            mViewComponent.get().onCaseStoriesAddImageButtonPressed(this);
        }
    }

    /**
     * Handle loading of images
     * @param imagePaths
     */
    @Override
    public void onImagesLoaded(List<String> imagePaths) {
        mImagePaths.addAll(imagePaths);
    }
}
