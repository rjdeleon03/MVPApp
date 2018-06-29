package com.cpu.quikdata.Modules.NewDnca.Livelihoods;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

import javax.annotation.Nullable;

public abstract class LivelihoodsEnumBaseViewModel extends BaseEnumViewModel {

    protected LivelihoodsRepositoryManager mLivelihoodsRepositoryManager;

    /**
     * Constructor
     * @param livelihoodsRepositoryManager
     * @param enumClass
     */
    public LivelihoodsEnumBaseViewModel(LivelihoodsRepositoryManager livelihoodsRepositoryManager,
                                        @Nullable Class<? extends Enum> enumClass) {
        super(enumClass);
        mLivelihoodsRepositoryManager = livelihoodsRepositoryManager;
    }
}
