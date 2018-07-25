package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashConditionsDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashConditionsDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class WashConditionsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, WashInformation> {

    private WashConditionsDetails mWashConditionsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public WashConditionsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getWashInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(WashInformation data) {
        mWashConditionsDetails = data.getWashConditionsDetails();

        for(QuestionItemModelMultChoice model : mWashConditionsDetails.getMultChoiceFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelMultChoice(model));
        }
        for(QuestionItemModelString model : mWashConditionsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
