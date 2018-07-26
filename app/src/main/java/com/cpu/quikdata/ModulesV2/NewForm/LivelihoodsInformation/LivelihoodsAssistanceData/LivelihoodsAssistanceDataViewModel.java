package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.LivelihoodsAssistanceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceDataViewModel;

public class LivelihoodsAssistanceDataViewModel extends AssistanceDataViewModel<LivelihoodsInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public LivelihoodsAssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }
}
