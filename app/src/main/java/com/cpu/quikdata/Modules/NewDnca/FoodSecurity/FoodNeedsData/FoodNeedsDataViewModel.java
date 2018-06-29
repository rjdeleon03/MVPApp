package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodNeedsData;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.FoodSecurity.FoodNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelInt;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodNeedsDataViewModel extends FoodSecurityBaseViewModel implements NonEnumSaveableSection {

    private String[] mQuestions = {
            "What assistance can be provided to fill the food gap?",
            "Number of families in need of food supply or lack the capacity to buy or secure food for their own consumption"
    };

    /**
     * Constructor
     * @param foodSecurityRepositoryManager
     */
    public FoodNeedsDataViewModel(FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(foodSecurityRepositoryManager);

        FoodNeedsData foodNeedsData = mFoodSecurityRepositoryManager.getFoodNeedsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], foodNeedsData.getAssistanceNeeded())));
        mQuestionsViewModels.add(new QuestionItemViewModelInt(new BaseQuestion(mQuestions[1], foodNeedsData.getNumberOfFamilies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FoodNeedsData foodNeedsData = new FoodNeedsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelInt) mQuestionsViewModels.get(1)).answer.get());
        mFoodSecurityRepositoryManager.saveFoodNeedsData(foodNeedsData);
    }
}
