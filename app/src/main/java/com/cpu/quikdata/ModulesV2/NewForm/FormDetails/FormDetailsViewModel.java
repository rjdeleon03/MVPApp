package com.cpu.quikdata.ModulesV2.NewForm.FormDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FormDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormDataManager;

public class FormDetailsViewModel extends TemplateQuestionViewModel<INewFormDataManager, FormDetails>{

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

        mQuestions.add(new QuestionItemModelString("Organization Name: ", mFormDetails.getOrgName()));
        mQuestions.add(new QuestionItemModelString("Sitio/Purok/Zone: ", mFormDetails.getSitio()));
        mQuestions.add(new QuestionItemModelString("Barangay: ", mFormDetails.getBarangay()));
        mQuestions.add(new QuestionItemModelString("Municipality/City: ", mFormDetails.getCity()));
        mQuestions.add(new QuestionItemModelString("Province: ", mFormDetails.getProvince()));
        mQuestions.add(new QuestionItemModelString("Name of Interviewer: ", mFormDetails.getInterviewer()));
        mQuestions.add(new QuestionItemModelString("Interviewer Contact Number: ", mFormDetails.getInterviewerNo()));
        mQuestions.add(new QuestionItemModelString("Sources of Information: ", mFormDetails.getInfoSources()));
    }
}
