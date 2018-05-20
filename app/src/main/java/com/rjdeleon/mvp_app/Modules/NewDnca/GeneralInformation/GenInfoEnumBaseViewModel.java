package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

public abstract class GenInfoEnumBaseViewModel extends BaseEnumViewModel {

    protected GenInfoRepositoryManager mGenInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param genInfoRepositoryManager
     * @param enumClass
     */
    public GenInfoEnumBaseViewModel(Context context,
                                    GenInfoRepositoryManager genInfoRepositoryManager,
                                    Class<? extends Enum> enumClass) {

        super(context, enumClass);
        mGenInfoRepositoryManager = genInfoRepositoryManager;
    }
}
