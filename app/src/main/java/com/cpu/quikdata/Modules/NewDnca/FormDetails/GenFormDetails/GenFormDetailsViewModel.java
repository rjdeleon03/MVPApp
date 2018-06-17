package com.cpu.quikdata.Modules.NewDnca.FormDetails.GenFormDetails;

import android.content.Context;

import com.cpu.quikdata.Models.FormDetails.GenFormDetails;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.FormDetailsRepositoryManager;

public class GenFormDetailsViewModel extends FormDetailsBaseViewModel {

    private String[] mQuestions = {
            "Name of Organization:",
            "Date of Assessment:",
            "Sitio/Purok/Zone:",
            "Barangay:",
            "Municipality/City:",
            "Province",
            "Interviewer's Name:",
            "Interviewer's Contact Number:",
            "Sources of Information:"
    };

    /**
     * Constructor
     * @param context
     * @param formDetailsRepositoryManager
     */
    public GenFormDetailsViewModel(Context context, FormDetailsRepositoryManager formDetailsRepositoryManager) {
        super(context, formDetailsRepositoryManager);

        GenFormDetails genFormDetails = mFormDetailsRepositoryManager.getGenFormDetails();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genFormDetails.getOrgName())));
        mQuestionsViewModels.add(new QuestionItemViewModelDate(new BaseQuestion(mQuestions[1], genFormDetails.getAssessmentDate())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], genFormDetails.getSitio())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], genFormDetails.getBarangay())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[4], genFormDetails.getCity())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[5], genFormDetails.getProvince())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[6], genFormDetails.getInterviewer())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[7], genFormDetails.getInterviewerNo())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[8], genFormDetails.getInfoSources())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenFormDetails genFormDetails = new GenFormDetails(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelDate) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(4)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(5)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(7)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(8)).answer.get());
        mFormDetailsRepositoryManager.saveGenFormDetails(genFormDetails);
    }
}
