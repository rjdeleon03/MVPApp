package com.cpu.quikdata.ModulesV2.Base.EnumData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

public abstract class TemplateEnumDataViewModel<AC extends ITemplateEnumDataFragment, D, E extends GenericEnum> extends BaseViewModel<AC> implements IBaseDataManager<D> {

    protected List<E> mTypeList;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    protected TemplateEnumDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mActivity.get() != null) {
            mActivity.get().onAddButtonPressed();
        }
    }
}
