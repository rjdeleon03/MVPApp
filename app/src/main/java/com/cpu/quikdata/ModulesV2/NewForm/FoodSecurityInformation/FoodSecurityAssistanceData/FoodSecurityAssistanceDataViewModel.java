package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityAssistanceData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataViewModel;

public class FoodSecurityAssistanceDataViewModel extends AssistanceDataViewModel<FoodSecurityInformation> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public FoodSecurityAssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFoodSecurityInformation(this);
    }
}
