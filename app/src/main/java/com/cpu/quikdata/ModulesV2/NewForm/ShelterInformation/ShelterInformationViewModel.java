package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class ShelterInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<ShelterInformation> {

    private ShelterInformation mShelterInformation;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterInformationViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getShelterInformation(this);
    }

    @Override
    public void onDataReceived(ShelterInformation data) {
        mShelterInformation = data;
    }
}
