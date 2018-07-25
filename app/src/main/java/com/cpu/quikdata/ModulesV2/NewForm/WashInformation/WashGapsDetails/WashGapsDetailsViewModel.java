package com.cpu.quikdata.ModulesV2.NewForm.WashInformation.WashGapsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.WashInformation.WashInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class WashGapsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, WashInformation> {

    private WashGapsDetails mWashGapsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public WashGapsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getWashInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(WashInformation data) {
        mWashGapsDetails = data.getWashGapsDetails();

        for(QuestionItemModelString model : mWashGapsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
