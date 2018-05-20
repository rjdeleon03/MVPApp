package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment.BaseMultiPageViewModel;

public class ShelterInfoViewModel extends BaseMultiPageViewModel {

    /**
     * Constructor
     *
     * @param context
     * @param dncaFormRepository
     */
    public ShelterInfoViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context, dncaFormRepository);
    }
}
