package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.Base.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class GeneralInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<GeneralInformation> {

    private GeneralInformation mGeneralInformation;

    public GeneralInformationViewModel(DNCAFormRepository dncaFormRepository)
    {
        super(dncaFormRepository);
        mFormRepository.getGeneralInformation(this);
    }

    @Override
    public void onDataReceived(GeneralInformation data) {
        mGeneralInformation = data;
    }
}
