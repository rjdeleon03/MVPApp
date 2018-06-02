package com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashGapsData;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Wash.WashGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseQuestion;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Wash.WashRepositoryManager;

public class WashGapsDataViewModel extends WashBaseViewModel {

    private String[] mQuestions = {
            "Are the assistance provided enough?",
            "Are the assistance provided relevant to the needs of the affected?",
            "Is the water source accessible?",
            "Were they consulted prior to the relief distribution?",
            "Is there an orientation on waste management?",
            "What is the attitude towards women, men, LGBT, PWD, boys and girls?",
            "Are there existing support mechanisms?",
            "Do women participate in decision making?"
    };

    /**
     * Constructor
     * @param context
     * @param washRepositoryManager
     */
    public WashGapsDataViewModel(Context context, WashRepositoryManager washRepositoryManager) {
        super(context, washRepositoryManager);

        WashGapsData washGapsData = mWashRepositoryManager.getGapsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], washGapsData.getIsAssistanceEnough())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], washGapsData.getIsAssistanceRelevant())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], washGapsData.getIsWaterSourceAccessible())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], washGapsData.getDidConsultBeforeDistribution())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[4], washGapsData.getHasWasteMgmtOrientation())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[5], washGapsData.getAttitudeTowardsGenders())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[6], washGapsData.getHasSupportMechanisms())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[7], washGapsData.getWomenParticipation())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        WashGapsData washGapsData = new WashGapsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(4)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(5)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(7)).answer.get());
        mWashRepositoryManager.saveGapsData(washGapsData);
    }
}
