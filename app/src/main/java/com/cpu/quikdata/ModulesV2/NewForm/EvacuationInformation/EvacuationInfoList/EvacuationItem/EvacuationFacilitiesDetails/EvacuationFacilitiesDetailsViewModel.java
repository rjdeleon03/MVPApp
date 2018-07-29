package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationFacilitiesDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationFacilitiesDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBooleanString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.IEvacuationItemDataManager;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class EvacuationFacilitiesDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, EvacuationItem> {

    private EvacuationFacilitiesDetails mEvacuationFacilitiesDetails;
    private IEvacuationItemDataManager mDataManager;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationFacilitiesDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(IEvacuationItemDataManager dataManager) {
        mDataManager = dataManager;
        mDataManager.getRow(this);
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
