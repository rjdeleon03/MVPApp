package com.cpu.quikdata.ModulesV2.Base.MultiPage;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

public abstract class TemplateMultiPageViewModel<A extends IBaseInterface> extends BaseViewModel<A> {

    /**
     * Constructor
     * @param dncaFormRepository
     */
    protected TemplateMultiPageViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }
}
