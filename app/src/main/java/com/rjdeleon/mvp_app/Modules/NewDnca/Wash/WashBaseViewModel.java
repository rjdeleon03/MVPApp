package com.rjdeleon.mvp_app.Modules.NewDnca.Wash;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class WashBaseViewModel extends BaseQuestionViewModel {

    protected WashRepositoryManager mWashRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param washRepositoryManager
     */
    public WashBaseViewModel(Context context, WashRepositoryManager washRepositoryManager) {
        super(context);
        mWashRepositoryManager = washRepositoryManager;
    }
}
