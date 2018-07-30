package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public abstract class EvacuationItemTemplateQuestionViewModel extends TemplateQuestionViewModel<INewFormActivity, EvacuationItem> {

    protected IEvacuationItemDataManager mDataManager;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationItemTemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(IEvacuationItemDataManager dataManager) {
        mDataManager = dataManager;
        mDataManager.getRow(this);
    }
}
