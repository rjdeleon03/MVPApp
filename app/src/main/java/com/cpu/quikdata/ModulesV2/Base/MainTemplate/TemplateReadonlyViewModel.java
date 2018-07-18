package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

public abstract class TemplateReadonlyViewModel<AC extends IBaseInterface, D> extends TemplateMainViewModel<AC, D> {

    /**
     * Constructor
     * @param dncaFormRepository
     */
    protected TemplateReadonlyViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mAdapter = new TemplateReadonlyAdapter(this);
    }
}
