package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsNeedsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsNeedsDataViewModel extends LivelihoodsBaseViewModel {

    private String[] mQuestions = {
            "What assistance can be provided to fill the income gap?",
            "What resources are needed to return to normal?",
            "How many families are in need of livelihood assistance?"
    };

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsNeedsDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsNeedsData needsData = mLivelihoodsRepositoryManager.getLivelihoodsNeedsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], needsData.getAssistanceToFillGap())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], needsData.getResourcesNeeded())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], needsData.getFamiliesNeedingAssistance())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsNeedsData needsData = new LivelihoodsNeedsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get());
        mLivelihoodsRepositoryManager.saveLivelihoodsNeedsData(needsData);
    }
}
