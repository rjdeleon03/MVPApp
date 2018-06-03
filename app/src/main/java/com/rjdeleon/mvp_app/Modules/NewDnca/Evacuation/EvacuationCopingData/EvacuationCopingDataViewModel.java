package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationCopingData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationRepositoryManager;

public class EvacuationCopingDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "What are the coping mechanisms or actions of the affected population?"
    };

    /**
     * Constructor
     * @param context
     * @param evacuationRepositoryManager
     */
    public EvacuationCopingDataViewModel(Context context, EvacuationRepositoryManager evacuationRepositoryManager) {
        super(context, evacuationRepositoryManager);

        GenericCopingData genericCopingData = mEvacuationRepositoryManager.getGenericCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genericCopingData.getCopingStrategies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData genericCopingData = new GenericCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get());
        mEvacuationRepositoryManager.saveGenericCopingData(genericCopingData);
    }
}
