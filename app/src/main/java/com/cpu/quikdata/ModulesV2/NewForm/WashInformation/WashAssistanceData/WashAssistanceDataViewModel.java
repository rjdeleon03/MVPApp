package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashAssistanceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataViewModel;

public class WashAssistanceDataViewModel extends AssistanceDataViewModel<WashInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public WashAssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getWashInformation(this);
    }
}
