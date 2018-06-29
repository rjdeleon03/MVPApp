package com.cpu.quikdata.Modules.NewDnca.FoodSecurity;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class FoodSecurityBaseViewModel extends BaseQuestionViewModel {

    protected FoodSecurityRepositoryManager mFoodSecurityRepositoryManager;

    /**
     * Constructor
     * @param foodSecurityRepositoryManager
     */
    public FoodSecurityBaseViewModel(FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super();
        mFoodSecurityRepositoryManager = foodSecurityRepositoryManager;
    }
}
