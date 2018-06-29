package com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.FoodSecurity.FoodGapsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodGapsDataViewModel extends FoodSecurityBaseViewModel {

    private String[] mQuestions = {
            "Is the assistance provided appropriate to the needs of the families?",
            "Is the assistance provided enough?",
            "Do women and men have equal access to the assistance?",
            "Were the specific food needs of men, women, boys, girls, pwd, children, breastfeeding and lactating women considered in the assistance?"
    };
    
    /**
     * Constructor
     * @param foodSecurityRepositoryManager
     */
    public FoodGapsDataViewModel(FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(foodSecurityRepositoryManager);

        FoodGapsData foodGapsData = mFoodSecurityRepositoryManager.getFoodGapsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], foodGapsData.getIsAssistanceAppropriate())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], foodGapsData.getIsAssistanceEnough())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], foodGapsData.getHasEqualAccess())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], foodGapsData.getWereAllConsidered())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FoodGapsData foodGapsData = new FoodGapsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get());
        mFoodSecurityRepositoryManager.saveFoodGapsData(foodGapsData);
    }
}
