package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterCopingDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterCopingDetails;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class ShelterCopingDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, ShelterInformation> {

    private ShelterCopingDetails mShelterCopingDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterCopingDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getShelterInformation(this);
    }

    /**
     * Handles reception of shelter information data
     * @param data
     */
    @Override
    public void onDataReceived(ShelterInformation data) {
        mShelterCopingDetails = data.getShelterCopingDetails();

        for(QuestionItemModelString model : mShelterCopingDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
