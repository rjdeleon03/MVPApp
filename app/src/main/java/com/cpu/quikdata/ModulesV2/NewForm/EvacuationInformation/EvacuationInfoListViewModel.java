package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationInformation;
import com.cpu.quikdata.ModulesV2.Base.ListData.TemplateListDataViewModel;
import com.cpu.quikdata.ModulesV2.FormList.IFormListActivity;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class EvacuationInfoListViewModel extends TemplateListDataViewModel<INewFormActivity, EvacuationInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets up the adapter
     */
    @Override
    protected void setupAdapter() {

    }

    /**
     * Handles the navigation when add button is pressed
     */
    @Override
    public void navigateOnAddButtonPressed() {

    }
}
