package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class EvacuationEnumBaseViewModel extends BaseEnumViewModel {

    protected EvacuationItemRepositoryManager mEvacuationItemRepositoryManager;

    /**
     * Constructor
     * @param enumClass
     */
    protected EvacuationEnumBaseViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager,
                                          @Nullable Class<? extends Enum> enumClass) {
        super(enumClass);
        mEvacuationItemRepositoryManager = evacuationItemRepositoryManager;
    }
}
