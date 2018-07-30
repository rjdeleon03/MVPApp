package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationProtectionDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationProtectionDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemTemplateQuestionViewModel;

public class EvacuationProtectionDetailsViewModel extends EvacuationItemTemplateQuestionViewModel {

    private EvacuationProtectionDetails mEvacuationProtectionDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationProtectionDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(EvacuationItem data) {
        mEvacuationProtectionDetails = data.getEvacuationProtectionDetails();

        for(QuestionItemModelBooleanString model : mEvacuationProtectionDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
    }
}
