package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class HealthInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<HealthInformation> {

    private HealthInformation mHealthInformation;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public HealthInformationViewModel(DNCAFormRepository dncaFormRepository)
    {
        super(dncaFormRepository);
        mFormRepository.getHealthInformation(this);
    }

    @Override
    public void onDataReceived(HealthInformation data) {
        mHealthInformation = data;
    }
}
