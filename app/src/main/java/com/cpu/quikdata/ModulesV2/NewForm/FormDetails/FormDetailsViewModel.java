package com.cpu.quikdata.ModulesV2.NewForm.FormDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FormDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormDataManager;

public class FormDetailsViewModel extends TemplateQuestionViewModel<INewFormActivity, FormDetails>{

    private FormDetails mFormDetails;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public FormDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFormDetails(this);
    }

    /**
     * Handles reception of form details
     * @param data
     */
    @Override
    public void onDataReceived(FormDetails data) {
        mFormDetails = data;

        mQuestions.add(new TemplateQuestionItemViewModelDate(data.getAssessmentDate()));
        mQuestions.add(new TemplateQuestionItemViewModelString(data.getInterviewer()));
        mQuestions.add(new TemplateQuestionItemViewModelString(data.getInterviewerNo()));
        mQuestions.add(new TemplateQuestionItemViewModelString(data.getInfoSources()));
    }
}
