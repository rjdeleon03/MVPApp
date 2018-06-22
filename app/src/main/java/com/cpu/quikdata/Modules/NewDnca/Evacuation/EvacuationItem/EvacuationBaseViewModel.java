package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class EvacuationBaseViewModel extends BaseQuestionViewModel {

    protected EvacuationItemRepositoryManager mEvacuationItemRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param evacuationItemRepositoryManager
     */
    public EvacuationBaseViewModel(Context context, EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(context);
        mEvacuationItemRepositoryManager = evacuationItemRepositoryManager;
    }
}
