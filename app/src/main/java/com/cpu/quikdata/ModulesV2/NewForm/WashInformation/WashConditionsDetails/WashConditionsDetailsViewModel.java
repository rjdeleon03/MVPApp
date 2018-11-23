package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashConditionsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashConditionsDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoiceRemarks;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;
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

        for(QuestionItemModelMultChoiceRemarks model : mWashConditionsDetails.getMultChoiceRemarksFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelMultChoiceRemarks(model));
        }
        for(QuestionItemModelBooleanString model : mWashConditionsDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
        for(QuestionItemModelSingleNumber model : mWashConditionsDetails.getNumberFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(model, true));
        }
        for(QuestionItemModelString model : mWashConditionsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
        mQuestions.add(3, new TemplateQuestionItemViewModelTextOnly(new QuestionItemModelTextOnly("otherWashConditionInfo")));
        mQuestions.add(0, new TemplateQuestionItemViewModelTextOnly(new QuestionItemModelTextOnly("currentWaterSource")));
    }
}
