package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseQuestionDataManager;

public class GeneralInformationViewModel implements IBaseDataManager<GeneralInformation> {

    private GeneralInformation mGeneralInformation;
    protected DNCAFormRepository mFormRepository;

    public GeneralInformationViewModel(DNCAFormRepository dncaFormRepository)
    {
        mFormRepository = dncaFormRepository;
        mFormRepository.getGeneralInformation(this);
    }

    @Override
    public void onDataReceived(GeneralInformation data) {
        mGeneralInformation = data;
    }
}
