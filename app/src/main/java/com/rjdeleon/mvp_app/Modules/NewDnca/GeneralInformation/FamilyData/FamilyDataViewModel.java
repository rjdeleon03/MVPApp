package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

public class FamilyDataViewModel extends NewDncaGenInfoBaseViewModel {

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public FamilyDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);
    }

    /**
     * Navigate when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {

    }
}
