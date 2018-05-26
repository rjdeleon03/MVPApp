package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class LivelihoodsBaseViewModel extends NewDncaBaseViewModel {

    protected LivelihoodsRepositoryManager mLivelihoodsRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsBaseViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context);
        mLivelihoodsRepositoryManager = livelihoodsRepositoryManager;
    }
}
