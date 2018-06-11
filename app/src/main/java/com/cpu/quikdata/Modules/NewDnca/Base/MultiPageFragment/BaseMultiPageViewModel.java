package com.cpu.quikdata.Modules.NewDnca.Base.MultiPageFragment;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;

public abstract class BaseMultiPageViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback {

    protected DNCAFormRepository mDncaFormRepository;
    protected DNCAForm mDncaForm;
    public final ObservableInt viewPagerIndex;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public BaseMultiPageViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
        viewPagerIndex = new ObservableInt(0);
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
