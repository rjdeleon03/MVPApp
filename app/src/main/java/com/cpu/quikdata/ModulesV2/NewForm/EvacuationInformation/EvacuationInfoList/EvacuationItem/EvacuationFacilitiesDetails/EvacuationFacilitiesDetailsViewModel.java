package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationFacilitiesDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationFacilitiesDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemTemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.IEvacuationItemDataManager;

public class EvacuationFacilitiesDetailsViewModel extends EvacuationItemTemplateQuestionViewModel {

    private EvacuationFacilitiesDetails mEvacuationFacilitiesDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationFacilitiesDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(EvacuationItem data) {
        mEvacuationFacilitiesDetails = data.getEvacuationFacilitiesDetails();

        for(QuestionItemModelBooleanString model : mEvacuationFacilitiesDetails.getBooleanStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelBooleanString(model));
        }
    }
}
