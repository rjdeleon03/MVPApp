package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthGapsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class HealthGapsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, HealthInformation> {

    private HealthGapsDetails mHealthGapsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public HealthGapsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getHealthInformation(this);
    }

    /**
     * Handles reception of livelihoods information data
     * @param data
     */
    @Override
    public void onDataReceived(HealthInformation data) {
        mHealthGapsDetails = data.getHealthGapsDetails();

        for(QuestionItemModelString model : mHealthGapsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
