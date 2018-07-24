package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.LivelihoodsInformation.LivelihoodsInformation;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class LivelihoodsInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<LivelihoodsInformation> {

    private LivelihoodsInformation mLivelihoodsInformation;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public LivelihoodsInformationViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getLivelihoodsInformation(this);
    }

    @Override
    public void onDataReceived(LivelihoodsInformation data) {
        mLivelihoodsInformation = data;
    }
}
