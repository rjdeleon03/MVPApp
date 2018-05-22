package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class FoodSecurityBaseViewModel extends NewDncaBaseViewModel {

    protected FoodSecurityRepositoryManager mFoodSecurityRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodSecurityBaseViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context);
        mFoodSecurityRepositoryManager = foodSecurityRepositoryManager;
    }
}
