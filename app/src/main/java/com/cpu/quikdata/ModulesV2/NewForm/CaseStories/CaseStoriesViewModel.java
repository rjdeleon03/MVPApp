package com.cpu.quikdata.ModulesV2.NewForm.CaseStories;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.CaseStories.CaseStories;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class CaseStoriesViewModel extends BaseViewModel<INewFormActivity> implements IBaseDataManager<CaseStories> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CaseStoriesViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
//        mFormRepository.getCaseStories(this);
    }

    /**
     * Handles reception of case stories data
     * @param data
     */
    @Override
    public void onDataReceived(CaseStories data) {

    }
}
