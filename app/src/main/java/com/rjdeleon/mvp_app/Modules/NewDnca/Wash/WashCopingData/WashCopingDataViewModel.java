package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashCopingData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashRepositoryManager;

public class WashCopingDataViewModel extends WashBaseViewModel {

    private String[] mQuestions = {
            "What are the coping strategies of the affected population?"
    };

    /**
     * Constructor
     * @param context
     * @param washRepositoryManager
     */
    public WashCopingDataViewModel(Context context, WashRepositoryManager washRepositoryManager) {
        super(context, washRepositoryManager);

        GenericCopingData genericCopingData = mWashRepositoryManager.getGenericCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genericCopingData.getCopingStrategies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData genericCopingData = new GenericCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get());
        mWashRepositoryManager.saveGenericCopingData(genericCopingData);
    }
}
