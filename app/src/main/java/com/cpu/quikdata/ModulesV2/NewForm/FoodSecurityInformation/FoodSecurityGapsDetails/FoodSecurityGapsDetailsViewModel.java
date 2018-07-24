package com.cpu.quikdata.ModulesV2.NewForm.FoodSecurityInformation.FoodSecurityGapsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.FoodSecurityInformation.FoodSecurityInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class FoodSecurityGapsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, FoodSecurityInformation> {

    private FoodSecurityGapsDetails mFoodSecurityGapsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public FoodSecurityGapsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFoodSecurityInformation(this);
    }

    /**
     * Handles reception of food security information data
     * @param data
     */
    @Override
    public void onDataReceived(FoodSecurityInformation data) {
        mFoodSecurityGapsDetails = data.getFoodSecurityGapsDetails();

        for(QuestionItemModelString model : mFoodSecurityGapsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
