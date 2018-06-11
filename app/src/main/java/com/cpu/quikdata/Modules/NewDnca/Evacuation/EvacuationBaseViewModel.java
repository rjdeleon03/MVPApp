package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

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
