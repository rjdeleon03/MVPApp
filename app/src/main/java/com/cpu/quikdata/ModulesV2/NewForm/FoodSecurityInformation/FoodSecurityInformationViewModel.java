package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

public class FoodSecurityInformationViewModel extends TemplateMultiPageViewModel<INewFormActivity> implements IBaseDataManager<FoodSecurityInformation> {

    private FoodSecurityInformation mFoodSecurityInformation;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public FoodSecurityInformationViewModel(DNCAFormRepository dncaFormRepository)
    {
        super(dncaFormRepository);
        mFormRepository.getFoodSecurityInformation(this);
    }

    @Override
    public void onDataReceived(FoodSecurityInformation data) {
        mFoodSecurityInformation = data;
    }
}
