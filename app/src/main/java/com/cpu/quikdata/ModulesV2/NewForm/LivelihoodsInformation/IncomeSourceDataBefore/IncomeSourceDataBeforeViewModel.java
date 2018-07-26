package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataBefore;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData.IncomeSourceDataViewModel;

public class IncomeSourceDataBeforeViewModel extends IncomeSourceDataViewModel {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public IncomeSourceDataBeforeViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    @Override
    protected void processReceivedData(LivelihoodsInformation data) {
        mRowHolder = data.getLivelihoodsIncomeSourceDataBefore();
    }
}
