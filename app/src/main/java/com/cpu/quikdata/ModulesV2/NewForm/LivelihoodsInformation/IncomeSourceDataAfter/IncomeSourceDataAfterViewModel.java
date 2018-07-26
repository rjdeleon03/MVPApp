package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataAfter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData.IncomeSourceDataViewModel;

public class IncomeSourceDataAfterViewModel extends IncomeSourceDataViewModel {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public IncomeSourceDataAfterViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    @Override
    protected void processReceivedData(LivelihoodsInformation data) {
        mRowHolder = data.getLivelihoodsIncomeSourceDataAfter();
    }
}
