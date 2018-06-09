package com.rjdeleon.mvp_app.Modules.NewDnca.Health;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class HealthBaseViewModel extends BaseQuestionViewModel {

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
