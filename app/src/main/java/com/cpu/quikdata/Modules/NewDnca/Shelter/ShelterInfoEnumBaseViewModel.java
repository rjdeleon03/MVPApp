package com.cpu.quikdata.Modules.NewDnca.Shelter;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public abstract class ShelterInfoEnumBaseViewModel extends BaseEnumViewModel {

    protected ShelterInfoRepositoryManager mShelterInfoRepositoryManager;

    /**
     * Constructor
     * @param shelterInfoRepositoryManager
     * @param enumClass
     */
    public ShelterInfoEnumBaseViewModel(ShelterInfoRepositoryManager shelterInfoRepositoryManager,
                                        Class<? extends Enum> enumClass) {

        super(enumClass);
        mShelterInfoRepositoryManager = shelterInfoRepositoryManager;
    }
}
