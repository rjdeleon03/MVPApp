package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class FormDetailsBaseViewModel extends BaseQuestionViewModel {

    protected FormDetailsRepositoryManager mFormDetailsRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param formDetailsRepositoryManager
     */
    public FormDetailsBaseViewModel(Context context, FormDetailsRepositoryManager formDetailsRepositoryManager) {
        super(context);
        mFormDetailsRepositoryManager = formDetailsRepositoryManager;
    }
}
