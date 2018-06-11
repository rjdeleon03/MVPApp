package com.cpu.quikdata.Modules.NewDnca.Health;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

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
