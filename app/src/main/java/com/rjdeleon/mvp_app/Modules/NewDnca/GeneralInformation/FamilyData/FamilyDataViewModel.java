package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

public class FamilyDataViewModel extends NewDncaBaseViewModel {

    private NewDncaGenInfoRepositoryManager mNewDncaGenInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public FamilyDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context);
        mNewDncaGenInfoRepositoryManager = newDncaGenInfoRepositoryManager;
    }
}
