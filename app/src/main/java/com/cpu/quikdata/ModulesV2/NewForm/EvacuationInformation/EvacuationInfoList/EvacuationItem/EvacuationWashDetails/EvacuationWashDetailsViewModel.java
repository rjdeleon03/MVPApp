package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationWashDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationWashDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemTemplateQuestionViewModel;

public class EvacuationWashDetailsViewModel extends EvacuationItemTemplateQuestionViewModel {

    private EvacuationWashDetails mEvacuationWashDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationWashDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(EvacuationItem data) {
        mEvacuationWashDetails = data.getEvacuationWashDetails();

        for(QuestionItemModelBooleanString model : mEvacuationWashDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
    }
}
