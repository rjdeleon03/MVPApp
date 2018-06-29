package com.cpu.quikdata.Modules.NewDnca.Wash;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class WashBaseViewModel extends BaseQuestionViewModel {

    protected WashRepositoryManager mWashRepositoryManager;

    /**
     * Constructor
     * @param washRepositoryManager
     */
    public WashBaseViewModel(WashRepositoryManager washRepositoryManager) {
        super();
        mWashRepositoryManager = washRepositoryManager;
    }
}
