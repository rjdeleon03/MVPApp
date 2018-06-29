package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;

public abstract class EvacuationBaseViewModel extends BaseQuestionViewModel {

    protected EvacuationItemRepositoryManager mEvacuationItemRepositoryManager;

    /**
     * Constructor
     * @param evacuationItemRepositoryManager
     */
    public EvacuationBaseViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super();
        mEvacuationItemRepositoryManager = evacuationItemRepositoryManager;
    }
}
