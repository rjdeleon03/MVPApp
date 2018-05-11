package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class NewDncaGenInfoBaseViewModel extends NewDncaBaseViewModel {

    protected NewDncaGenInfoRepositoryManager mNewDncaGenInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public NewDncaGenInfoBaseViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context);
        mNewDncaGenInfoRepositoryManager = newDncaGenInfoRepositoryManager;
    }
}
