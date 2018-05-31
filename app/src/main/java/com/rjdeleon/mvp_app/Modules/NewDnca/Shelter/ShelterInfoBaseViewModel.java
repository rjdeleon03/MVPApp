package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public abstract class ShelterInfoBaseViewModel extends NewDncaBaseViewModel {

    protected ShelterInfoRepositoryManager mShelterInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterInfoBaseViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context);
        mShelterInfoRepositoryManager = shelterInfoRepositoryManager;
    }
}
