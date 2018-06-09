package com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodImpactData;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.FoodSecurity.FoodImpactData;
import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestionMultipleValue;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelDoubleString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelLevels;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.FoodSecurity.FoodSecurityRepositoryManager;

public class FoodImpactDataViewModel extends FoodSecurityBaseViewModel {

    private String[] mQuestions = {
            "How is food security affected?\n" +
                    "Problem of availability of food?",
            "Lack of access to food? (cash shortage)",
            "Constraints in accessing food and markets?",
            "Are there other sources of food and how long will this last?",
            "How many times a day were households eating?",
            "Are they able to meet their food needs?",
            "How has food production changed? (are they still able to fish or farm?)",
            "When is the next food ration needed and for how long?"
    };

    private String[] mSubQuestions = {
            "Before the emergency:",
            "After the emergency:"
    };

    /**
     * Constructor
     * @param context
     * @param foodSecurityRepositoryManager
     */
    public FoodImpactDataViewModel(Context context, FoodSecurityRepositoryManager foodSecurityRepositoryManager) {
        super(context, foodSecurityRepositoryManager);

        FoodImpactData foodImpactData = mFoodSecurityRepositoryManager.getFoodImpactData();
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[0],
                foodImpactData.getFoodAvailability().isYes, foodImpactData.getFoodAvailability().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1],
                foodImpactData.getLackOfFoodAccess().isYes, foodImpactData.getLackOfFoodAccess().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2],
                foodImpactData.getFoodConstraints().isYes, foodImpactData.getFoodConstraints().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3],
                foodImpactData.getFoodSources().isYes, foodImpactData.getFoodSources().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelDoubleString(new BaseQuestionMultipleValue(mQuestions[4], null,
                foodImpactData.getTimesEatingBefore(), foodImpactData.getTimesEatingAfter()), mSubQuestions[0], mSubQuestions[1]));
        mQuestionsViewModels.add(new QuestionItemViewModelDoubleString(new BaseQuestionMultipleValue(mQuestions[5], null,
                foodImpactData.getTimesEatingBefore(), foodImpactData.getTimesEatingAfter()), mSubQuestions[0], mSubQuestions[1]));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[6], foodImpactData.getFoodProdChanged())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[7], foodImpactData.getNextFoodRation())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        QuestionItemViewModelBoolean foodAvailabilityViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(0);
        QuestionItemViewModelBoolean lackOfFoodAccessViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(1);
        QuestionItemViewModelBoolean foodConstraintsViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(2);
        QuestionItemViewModelBoolean foodSourcesViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(3);
        QuestionItemViewModelDoubleString timesEatingViewModel = (QuestionItemViewModelDoubleString) mQuestionsViewModels.get(4);
        QuestionItemViewModelDoubleString meetFoodNeedsViewModel = (QuestionItemViewModelDoubleString) mQuestionsViewModels.get(5);

        FoodImpactData foodImpactData = new FoodImpactData(
                new BoolRemarksTuple(foodAvailabilityViewModel.answer.get(), foodAvailabilityViewModel.remarks.get()),
                new BoolRemarksTuple(lackOfFoodAccessViewModel.answer.get(), lackOfFoodAccessViewModel.remarks.get()),
                new BoolRemarksTuple(foodConstraintsViewModel.answer.get(), foodConstraintsViewModel.remarks.get()),
                new BoolRemarksTuple(foodSourcesViewModel.answer.get(), foodSourcesViewModel.remarks.get()),
                timesEatingViewModel.answer1.get(),
                timesEatingViewModel.answer2.get(),
                meetFoodNeedsViewModel.answer1.get(),
                meetFoodNeedsViewModel.answer2.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(7)).answer.get());
        mFoodSecurityRepositoryManager.saveFoodImpactData(foodImpactData);
    }
}
