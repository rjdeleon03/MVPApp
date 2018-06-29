package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodCopingData;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashRepositoryManager;

public class FoodCopingDataViewModel extends FoodSecurityBaseViewModel {

    private String[] mQuestions = {
            "What are the coping strategies employed?"
    };

    /**
     * Constructor
     * @param foodSecurityRepositoryManager
     */
    public FoodCopingDataViewModel(FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(foodSecurityRepositoryManager);

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
