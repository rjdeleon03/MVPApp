package com.cpu.quikdata.Modules.NewDnca.GeneralInformation;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class GenInfoBaseViewModel extends BaseQuestionViewModel {

    protected GenInfoRepositoryManager mGenInfoRepositoryManager;

    /**
     * Constructor
     * @param genInfoRepositoryManager
     */
    public GenInfoBaseViewModel(GenInfoRepositoryManager genInfoRepositoryManager) {
        super();
        mGenInfoRepositoryManager = genInfoRepositoryManager;
    }
}
