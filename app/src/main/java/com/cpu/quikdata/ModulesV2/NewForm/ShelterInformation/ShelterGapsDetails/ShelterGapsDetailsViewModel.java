package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterGapsDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterGapsDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class ShelterGapsDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, ShelterInformation> {

    private ShelterGapsDetails mShelterGapsDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterGapsDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getShelterInformation(this);
    }

    /**
     * Handles reception of shelter information data
     * @param data
     */
    @Override
    public void onDataReceived(ShelterInformation data) {
        mShelterGapsDetails = data.getShelterGapsDetails();

        for(QuestionItemModelString model : mShelterGapsDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
