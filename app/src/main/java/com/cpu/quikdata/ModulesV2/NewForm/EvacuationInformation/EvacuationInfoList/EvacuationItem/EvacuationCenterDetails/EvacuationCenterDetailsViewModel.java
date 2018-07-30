package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationCenterDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationCenterDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CalamityDetails;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelBoolean;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelMultChoice;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationItemTemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.IEvacuationItemDataManager;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;

public class EvacuationCenterDetailsViewModel extends EvacuationItemTemplateQuestionViewModel {

    private EvacuationCenterDetails mEvacuationCenterDetails;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationCenterDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
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

        int i = 2;
        for(QuestionItemModelMultChoice model : mEvacuationCenterDetails.getMultChoiceFields()) {
            mQuestions.add(i, new TemplateQuestionItemViewModelMultChoice(model));
            i++;
        }

        for(QuestionItemModelBoolean model : mEvacuationCenterDetails.getBooleanFields()) {
            mQuestions.add(i, new TemplateQuestionItemViewModelBoolean(model));
            i++;
        }

        for(QuestionItemModelDate model : mEvacuationCenterDetails.getDateFields()) {
            mQuestions.add(i+1, new TemplateQuestionItemViewModelDate(model));
        }
    }
}
