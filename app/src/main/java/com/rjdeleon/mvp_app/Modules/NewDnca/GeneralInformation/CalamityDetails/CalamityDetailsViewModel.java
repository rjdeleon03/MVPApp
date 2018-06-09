package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public class CalamityDetailsViewModel extends GenInfoBaseViewModel {

    private String[] mQuestions = {
            "Type of Calamity:",
            "Date of Occurrence:",
            "Description of the Event:",
            "Brief Description of the Affected Area:"
    };

    /**
     * Constructor
     * @param context
     * @param genInfoRepositoryManager
     */
    public CalamityDetailsViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context, genInfoRepositoryManager);

        CalamityDesc calamityDesc = mGenInfoRepositoryManager.getCalamityDetails();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], calamityDesc.getCalamityType())));
        mQuestionsViewModels.add(new QuestionItemViewModelDate(new BaseQuestion(mQuestions[1], calamityDesc.getDateOccurred())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], calamityDesc.getEventDescription())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], calamityDesc.getAreaDescription())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        CalamityDesc calamityDesc = new CalamityDesc(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelDate) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get());
        mGenInfoRepositoryManager.saveCalamityDetails(calamityDesc);
    }

    /**
     * Sets the assessment date
     * @param year
     * @param month
     * @param day
     */
    public void onDateOccurredSet(int year, int month, int day) {
//        dateOccurred.set(new SimpleDate(year, month, day));
    }
}
