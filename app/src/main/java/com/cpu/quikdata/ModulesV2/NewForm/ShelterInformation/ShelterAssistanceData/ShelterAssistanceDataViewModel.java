package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterAssistanceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataViewModel;

public class ShelterAssistanceDataViewModel extends AssistanceDataViewModel<ShelterInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterAssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getShelterInformation(this);
    }
}
