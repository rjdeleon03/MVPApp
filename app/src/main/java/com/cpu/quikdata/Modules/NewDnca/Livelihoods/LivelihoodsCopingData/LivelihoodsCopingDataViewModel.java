package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsCopingDataViewModel extends LivelihoodsBaseViewModel {

    private String[] mQuestions = {
            "How are people responding to livelihoods problems? What coping strategies do they employ?",
            "Are there new income opportunities?",
            "Are there any livelihood skills available in the community? (carpentry, masonry, etc.)"
    };

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsCopingDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsCopingData copingData = mLivelihoodsRepositoryManager.getLivelihoodsCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], copingData.getCopingStrategies())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], copingData.getIncomeOpportunities())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], copingData.getLivelihoodSkills())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsCopingData copingData = new LivelihoodsCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get());
        mLivelihoodsRepositoryManager.saveLivelihoodsCopingData(copingData);
    }
}
