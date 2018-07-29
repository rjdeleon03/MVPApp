package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCenterDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationCenterDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.IEvacuationItemDataManager;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class EvacuationCenterDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, EvacuationItem> {

    private EvacuationCenterDetails mEvacuationCenterDetails;
    private IEvacuationItemDataManager mDataManager;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationCenterDetailsViewModel(DNCAFormRepository dncaFormRepository) {
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
        mEvacuationCenterDetails = data.getEvacuationCenterDetails();

        for(QuestionItemModelString model : mEvacuationCenterDetails.getStringFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelString(model));
        }
        for(QuestionItemModelMultChoice model : mEvacuationCenterDetails.getMultChoiceFields()) {
            mQuestions.add(new TemplateQuestionItemViewModelMultChoice(model));
        }
    }
}
