package com.cpu.quikdata.Modules.NewDnca.FoodSecurity;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class FoodSecurityBaseViewModel extends BaseQuestionViewModel {

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
