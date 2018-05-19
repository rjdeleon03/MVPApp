package com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;

public class BaseMultiPageViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    protected DNCAFormRepository mDncaFormRepository;
    protected DNCAForm mDncaForm;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public BaseMultiPageViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        mDncaForm = form;
        retrieveDataAfterFormLoaded();
    }

    @Override
    public void onDataNotAvailable() {

    }

    protected void retrieveDataAfterFormLoaded() {}
}
