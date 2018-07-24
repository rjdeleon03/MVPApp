package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.ImpactDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
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

public class ImpactDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, FoodSecurityInformation> {

    private ImpactDetails mImpactDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ImpactDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFoodSecurityInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(FoodSecurityInformation data) {
        mImpactDetails = data.getImpactDetails();

        for(QuestionItemModelBooleanString model : mImpactDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
        for(QuestionItemModelDoubleString model : mImpactDetails.getDoubleStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelDoubleString(model));
        }
        for(QuestionItemModelString model : mImpactDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
