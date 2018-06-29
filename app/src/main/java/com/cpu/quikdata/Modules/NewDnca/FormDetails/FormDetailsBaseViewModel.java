package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class FormDetailsBaseViewModel extends BaseQuestionViewModel {

    protected IFormDetailsViewModel mIFormDetailsViewModel;

    /**
     * Constructor
     * @param iFormDetailsViewModel
     */
    public FormDetailsBaseViewModel(IFormDetailsViewModel iFormDetailsViewModel) {
        super();
        mIFormDetailsViewModel = iFormDetailsViewModel;
    }
}
