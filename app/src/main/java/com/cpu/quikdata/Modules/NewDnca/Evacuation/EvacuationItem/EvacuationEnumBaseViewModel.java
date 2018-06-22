package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class EvacuationEnumBaseViewModel extends BaseEnumViewModel {

    protected EvacuationItemRepositoryManager mEvacuationItemRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param enumClass
     */
    protected EvacuationEnumBaseViewModel(Context context,
                                          EvacuationItemRepositoryManager evacuationItemRepositoryManager,
                                          @Nullable Class<? extends Enum> enumClass) {
        super(context, enumClass);
        mEvacuationItemRepositoryManager = evacuationItemRepositoryManager;
    }
}
