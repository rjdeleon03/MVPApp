package com.cpu.quikdata.Modules.NewDnca.CaseStories;

import android.content.Context;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.CameraOwner;

import java.util.ArrayList;
import java.util.List;

public class CaseStoriesViewModel extends NewDncaBaseViewModel implements NonEnumSaveableSection, CameraOwner {

    private DNCAFormRepository mDncaFormRepository;
    private CaseStoriesNavigator mCaseStoriesNavigator;
    private List<String> mImagePaths = new ArrayList<>();

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     * @param caseStoriesNavigator
     */
    public CaseStoriesViewModel(Context context, DNCAFormRepository dncaFormRepository, CaseStoriesNavigator caseStoriesNavigator) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
        mCaseStoriesNavigator = caseStoriesNavigator;
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

    }

    /**
     * Adds image path to list of image paths
     * @param path
     */
    @Override
    public void addImagePath(String path) {
        mImagePaths.add(path);
    }
}
