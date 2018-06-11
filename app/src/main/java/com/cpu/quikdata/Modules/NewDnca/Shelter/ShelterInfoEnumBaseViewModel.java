package com.cpu.quikdata.Modules.NewDnca.Shelter;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public abstract class ShelterInfoEnumBaseViewModel extends BaseEnumViewModel {

    protected ShelterInfoRepositoryManager mShelterInfoRepositoryManager;

    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     * @param enumClass
     */
    public ShelterInfoEnumBaseViewModel(Context context,
                                        ShelterInfoRepositoryManager shelterInfoRepositoryManager,
                                        Class<? extends Enum> enumClass) {

        super(context, enumClass);
        mShelterInfoRepositoryManager = shelterInfoRepositoryManager;
    }
}
