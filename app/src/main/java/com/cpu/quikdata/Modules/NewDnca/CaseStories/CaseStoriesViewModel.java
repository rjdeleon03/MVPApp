package com.cpu.quikdata.Modules.NewDnca.CaseStories;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import com.cpu.quikdata.AppConstants;
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
    public final ObservableList<String> imagePaths = new ObservableArrayList<>();

    /**
     * Constructor
     * @param dncaFormRepository
     * @param caseStoriesNavigator
     */
    public CaseStoriesViewModel(DNCAFormRepository dncaFormRepository, CaseStoriesNavigator caseStoriesNavigator) {
        super(dncaFormRepository);
        mCaseStoriesNavigator = caseStoriesNavigator;
    }

    /**
     * Refresh viewModel with correct data when view is reshown
     */
    public void refreshViewModel() {
        if (imagePaths != null) {
            imagePaths.clear();
            imagePaths.addAll(mDncaForm.getCaseStories().getImages());
        }
    }

    /**
     * Override parent method to handle DNCA form data when loaded
     */
    @Override
    public void retrieveDataAfterFormLoaded() {
        if (imagePaths != null) {
            imagePaths.addAll(mDncaForm.getCaseStories().getImages());
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
        CaseStories caseStories = new CaseStories();
        caseStories.getImages().addAll(imagePaths);
        mDncaForm.setCaseStories(caseStories);

        if (mNewDncaNavigator != null)
            mNewDncaNavigator.onBackButtonPressed();
    }

    /**
     * Gets number of image paths
     * @return
     */
    public int getImagePathsCount() {
        return imagePaths.size();
    }

    /**
     * Adds image path to list of image paths
     * @param path
     */
    @Override
    public void addImagePath(String path) {
        if (AppConstants.MAX_IMAGE_COUNT <= imagePaths.size()) return;
        imagePaths.add(path);
    }

    /**
     * Deletes image path at specified index
     * @param rowIndex
     */
    @Override
    public void deleteImagePath(int rowIndex) {
        imagePaths.remove(rowIndex);
        mCaseStoriesNavigator.onImagesUpdated();
    }

    /**
     * Gets image path at specified index
     * @param rowIndex
     * @return
     */
    @Override
    public String getImagePath(int rowIndex) {
        return imagePaths.get(rowIndex);
    }
}
