package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class CalamityDetailsViewModel extends NewDncaBaseViewModel {

    private DNCAFormRepository mDncaFormRepository;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public CalamityDetailsViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
    }


}
