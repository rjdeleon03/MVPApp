package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsGapsData;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsGapsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsGapsDataViewModel extends LivelihoodsBaseViewModel {

    private String[] mQuestions = {
            "Do women and men have equal access to:\n" + "Local Market",
            "Cash and Food-for-Work Opportunities",
            "Credit",
            "Livelihood Materials and Services"
    };

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsGapsDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsGapsData gapsData = mLivelihoodsRepositoryManager.getLivelihoodsGapsData();
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[0],
                gapsData.getLocalMarket().isYes), gapsData.getLocalMarket().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1],
                gapsData.getOpportunities().isYes), gapsData.getOpportunities().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2],
                gapsData.getCredit().isYes), gapsData.getCredit().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3],
                gapsData.getLivelihoodMaterials().isYes), gapsData.getLivelihoodMaterials().remarks));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        QuestionItemViewModelBoolean localMarketViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(0);
        QuestionItemViewModelBoolean opportunitiesViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(1);
        QuestionItemViewModelBoolean creditViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(2);
        QuestionItemViewModelBoolean livelihoodMaterialsViewModel = (QuestionItemViewModelBoolean) mQuestionsViewModels.get(3);

        LivelihoodsGapsData gapsData = new LivelihoodsGapsData(
                new BoolRemarksTuple(localMarketViewModel.answer.get(), localMarketViewModel.remarks.get()),
                new BoolRemarksTuple(opportunitiesViewModel.answer.get(), opportunitiesViewModel.remarks.get()),
                new BoolRemarksTuple(creditViewModel.answer.get(), creditViewModel.remarks.get()),
                new BoolRemarksTuple(livelihoodMaterialsViewModel.answer.get(), livelihoodMaterialsViewModel.remarks.get()));
        mLivelihoodsRepositoryManager.saveLivelihoodsGapsData(gapsData);
    }
}
