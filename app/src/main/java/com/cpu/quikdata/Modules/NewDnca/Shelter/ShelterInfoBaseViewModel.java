package com.cpu.quikdata.Modules.NewDnca.Shelter;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public abstract class ShelterInfoBaseViewModel extends BaseQuestionViewModel {

    protected ShelterInfoRepositoryManager mShelterInfoRepositoryManager;

    /**
     * Constructor
     * @param shelterInfoRepositoryManager
     */
    public ShelterInfoBaseViewModel(ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super();
        mShelterInfoRepositoryManager = shelterInfoRepositoryManager;
    }
}
