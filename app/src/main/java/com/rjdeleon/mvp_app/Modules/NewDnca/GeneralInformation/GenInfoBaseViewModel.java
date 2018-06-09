package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class GenInfoBaseViewModel extends BaseQuestionViewModel {

    protected GenInfoRepositoryManager mGenInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param genInfoRepositoryManager
     */
    public GenInfoBaseViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context);
        mGenInfoRepositoryManager = genInfoRepositoryManager;
    }
}
