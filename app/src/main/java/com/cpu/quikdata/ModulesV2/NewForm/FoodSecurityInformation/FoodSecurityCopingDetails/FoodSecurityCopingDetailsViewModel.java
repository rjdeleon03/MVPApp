package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityCopingDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.ImpactDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDoubleString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class FoodSecurityCopingDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, FoodSecurityInformation> {

    private FoodSecurityCopingDetails mFoodSecurityCopingDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public FoodSecurityCopingDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFoodSecurityInformation(this);
    }

    /**
     * Handles reception of food security information data
     * @param data
     */
    @Override
    public void onDataReceived(FoodSecurityInformation data) {
        mFoodSecurityCopingDetails = data.getFoodSecurityCopingDetails();

        for(QuestionItemModelString model : mFoodSecurityCopingDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
