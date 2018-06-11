package com.cpu.quikdata.Modules.NewDnca.Wash;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

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
