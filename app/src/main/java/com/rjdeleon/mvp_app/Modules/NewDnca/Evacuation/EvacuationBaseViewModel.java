package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Evacuation.EvacuationSiteData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class EvacuationBaseViewModel extends BaseQuestionViewModel {

    protected EvacuationRepositoryManager mEvacuationRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param evacuationRepositoryManager
     */
    public EvacuationBaseViewModel(Context context, EvacuationRepositoryManager evacuationRepositoryManager) {
        super(context);
        mEvacuationRepositoryManager = evacuationRepositoryManager;
    }
}
