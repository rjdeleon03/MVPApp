package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashCopingDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class WashCopingDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, WashInformation> {

    private WashCopingDetails mWashCopingDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public WashCopingDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getWashInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(WashInformation data) {
        mWashCopingDetails = data.getWashCopingDetails();

        for(QuestionItemModelString model : mWashCopingDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
