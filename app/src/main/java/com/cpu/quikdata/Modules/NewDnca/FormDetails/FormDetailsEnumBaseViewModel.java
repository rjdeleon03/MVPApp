package com.cpu.quikdata.Modules.NewDnca.FormDetails;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumViewModel;

public abstract class FormDetailsEnumBaseViewModel extends BaseEnumViewModel {

    protected IFormDetailsViewModel mIFormDetailsViewModel;

    /**
     * Constructor
     * @param iFormDetailsViewModel
     */
    public FormDetailsEnumBaseViewModel(IFormDetailsViewModel iFormDetailsViewModel) {
        super(null);
        mIFormDetailsViewModel = iFormDetailsViewModel;
    }
}
