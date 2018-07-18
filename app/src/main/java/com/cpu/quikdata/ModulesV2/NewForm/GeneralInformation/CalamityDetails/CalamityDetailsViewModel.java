package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CalamityDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class CalamityDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, GeneralInformation> {

    private CalamityDetails mCalamityDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CalamityDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getGeneralInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(GeneralInformation data) {
        mCalamityDetails = data.getCalamityDetails();

        mQuestions.add(new TemplateQuestionItemViewModelString(new QuestionItemModelString("Calamity Type: ", mCalamityDetails.getCalamityType())));
        mQuestions.add(new TemplateQuestionItemViewModelString(new QuestionItemModelString("Event Description: ", mCalamityDetails.getEventDesc())));
        mQuestions.add(new TemplateQuestionItemViewModelString(new QuestionItemModelString("Area Description: ", mCalamityDetails.getAreaDesc())));
    }
}
