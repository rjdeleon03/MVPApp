package com.cpu.quikdata.Modules.NewDnca.CaseStories.Image;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.CaseStories.CaseStoriesRepositoryManager;

public class CaseStoriesImageViewModel extends NewDncaBaseViewModel {

    private CaseStoriesRepositoryManager mCaseStoriesRepositoryManager;
    private String mImagePath;

    /**
     * Constructor
     * @param context
     * @param caseStoriesRepositoryManager
     * @param index
     */
    public CaseStoriesImageViewModel(Context context,
                                     CaseStoriesRepositoryManager caseStoriesRepositoryManager,
                                     int index) {
        super(context);
        mCaseStoriesRepositoryManager = caseStoriesRepositoryManager;

        mImagePath = mCaseStoriesRepositoryManager.getImagePath(index);
    }

    /**
     * Gets image path
     * @return
     */
    public String getImagePath() {
        return mImagePath;
    }
}
