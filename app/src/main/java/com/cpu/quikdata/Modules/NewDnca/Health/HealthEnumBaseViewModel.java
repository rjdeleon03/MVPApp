package com.cpu.quikdata.Modules.NewDnca.Health;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class HealthEnumBaseViewModel extends BaseEnumViewModel {

    protected HealthRepositoryManager mHealthRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param enumClass
     */
    protected HealthEnumBaseViewModel(Context context,
                                      HealthRepositoryManager healthRepositoryManager,
                                      @Nullable Class<? extends Enum> enumClass) {
        super(context, enumClass);
        mHealthRepositoryManager = healthRepositoryManager;
    }
}
