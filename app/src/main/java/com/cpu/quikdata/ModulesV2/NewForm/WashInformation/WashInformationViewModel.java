package com.cpu.quikdata.ModulesV2.NewForm.WashInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class WashInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<WashInformation> {

    private WashInformation mWashInformation;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public WashInformationViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getWashInformation(this);
    }

    @Override
    public void onDataReceived(WashInformation data) {
        mWashInformation = data;
    }
}
