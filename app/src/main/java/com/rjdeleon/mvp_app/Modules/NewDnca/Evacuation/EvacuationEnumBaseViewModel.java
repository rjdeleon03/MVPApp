package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class EvacuationEnumBaseViewModel extends BaseEnumViewModel {

    protected EvacuationRepositoryManager mEvacuationRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param enumClass
     */
    protected EvacuationEnumBaseViewModel(Context context,
                                          EvacuationRepositoryManager evacuationRepositoryManager,
                                          @Nullable Class<? extends Enum> enumClass) {
        super(context, enumClass);
        mEvacuationRepositoryManager = evacuationRepositoryManager;
    }
}
