package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.FamilyDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.FamilyDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class FamilyDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, GeneralInformation> {

    private FamilyDetails mFamilyDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public FamilyDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getGeneralInformation(this);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(GeneralInformation data) {
        mFamilyDetails = data.getFamilyDetails();

        for(QuestionItemModelSingleNumber model : mFamilyDetails.getNumberFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
    }
}
