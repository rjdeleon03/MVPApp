package com.cpu.quikdata.ModulesV2.Base.EnumData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public abstract class TemplateEnumDataViewModel<AC, D> extends BaseViewModel<AC> implements IBaseDataManager<D> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateEnumDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }
}
