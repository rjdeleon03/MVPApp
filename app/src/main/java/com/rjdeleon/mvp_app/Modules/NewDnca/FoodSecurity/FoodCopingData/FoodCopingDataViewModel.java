package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodCopingData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashRepositoryManager;

public class FoodCopingDataViewModel extends FoodSecurityBaseViewModel {

    private String[] mQuestions = {
            "What are the coping strategies employed?"
    };

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodCopingDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        GenericCopingData genericCopingData = mFoodSecurityRepositoryManager.getGenericCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genericCopingData.getCopingStrategies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData genericCopingData = new GenericCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get());
        mFoodSecurityRepositoryManager.saveGenericCopingData(genericCopingData);
    }
}
