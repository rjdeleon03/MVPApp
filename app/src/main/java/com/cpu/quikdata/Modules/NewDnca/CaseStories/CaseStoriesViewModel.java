package com.cpu.quikdata.Modules.NewDnca.CaseStories;

import android.content.Context;

import com.cpu.quikdata.Models.CaseStories;
import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.CameraOwner;

import java.util.ArrayList;
import java.util.List;

public class CaseStoriesViewModel extends BaseMultiPageViewModel implements
        NonEnumSaveableSection, CameraOwner, CaseStoriesRepositoryManager, DNCAFormDataSource.GetDncaFormCallback {

    private CaseStoriesNavigator mCaseStoriesNavigator;
    private List<String> mImagePaths = new ArrayList<>();

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     * @param caseStoriesNavigator
     */
    public CaseStoriesViewModel(Context context, DNCAFormRepository dncaFormRepository, CaseStoriesNavigator caseStoriesNavigator) {
        super(context, dncaFormRepository);
        mDncaFormRepository.retrieveNewDncaForm(this);
        mCaseStoriesNavigator = caseStoriesNavigator;
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        if (mImagePaths != null) {
            mImagePaths.addAll(mDncaForm.getCaseStories().getImages());
        }
    }

    /**
     * Handles navigation when camera button pressed
     */
    public void navigateOnCameraButtonPressed() {
        mCaseStoriesNavigator.onCameraButtonPressed(this);
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        mDncaForm.setCaseStories(new CaseStories(mImagePaths));

        if (mNewDncaNavigator != null)
            mNewDncaNavigator.onBackButtonPressed();
    }

    /**
     * Gets number of image paths
     * @return
     */
    public int getImagePathsCount() {
        return mImagePaths.size();
    }

    /**
     * Adds image path to list of image paths
     * @param path
     */
    @Override
    public void addImagePath(String path) {
        mImagePaths.add(path);
    }

    /**
     * Deletes image path at specified index
     * @param rowIndex
     */
    @Override
    public void deleteImagePath(int rowIndex) {
        mImagePaths.remove(rowIndex);
    }

    /**
     * Gets image path at specified index
     * @param rowIndex
     * @return
     */
    @Override
    public String getImagePath(int rowIndex) {
        return mImagePaths.get(rowIndex);
    }
}
