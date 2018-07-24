package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.HealthCopingDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class HealthCopingDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, HealthInformation> {

    private HealthCopingDetails mHealthCopingDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public HealthCopingDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getHealthInformation(this);
    }

    /**
     * Handles reception of livelihoods information data
     * @param data
     */
    @Override
    public void onDataReceived(HealthInformation data) {
        mHealthCopingDetails = data.getHealthCopingDetails();

        for(QuestionItemModelString model : mHealthCopingDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
