package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Shelter.ShelterCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

public class ShelterCopingDataViewModel extends ShelterInfoBaseViewModel {

    private String[] mQuestions = {
            "Where are the displaced families staying?",
            "How will they get their homes back to reasonable standard of living?",
            "When can they return home?",
            "What will they do if they cannot return home?"
    };

    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterCopingDataViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager);

        ShelterCopingData copingData = mShelterInfoRepositoryManager.getShelterCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], copingData.getEvacuationSitesLocation())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], copingData.getHowToCope())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], copingData.getWhenToGoHome())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], copingData.getWhatIfCantGoHome())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterCopingData copingData = new ShelterCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get());
        mShelterInfoRepositoryManager.saveShelterCopingData(copingData);
    }

}
