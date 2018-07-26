package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthAssistanceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataViewModel;

public class HealthAssistanceDataViewModel extends AssistanceDataViewModel<HealthInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public HealthAssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getHealthInformation(this);
    }
}
