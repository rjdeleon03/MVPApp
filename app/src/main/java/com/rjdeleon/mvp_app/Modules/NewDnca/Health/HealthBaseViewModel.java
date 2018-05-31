package com.rjdeleon.mvp_app.Modules.NewDnca.Health;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class HealthBaseViewModel extends NewDncaBaseViewModel{

    protected HealthRepositoryManager mHealthRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param healthRepositoryManager
     */
    public HealthBaseViewModel(Context context, HealthRepositoryManager healthRepositoryManager) {
        super(context);
        mHealthRepositoryManager = healthRepositoryManager;
    }
}
