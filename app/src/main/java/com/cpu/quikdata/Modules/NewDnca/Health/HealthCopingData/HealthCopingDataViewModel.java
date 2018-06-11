package com.cpu.quikdata.Modules.NewDnca.Health.HealthCopingData;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashRepositoryManager;

public class HealthCopingDataViewModel extends HealthBaseViewModel {

    private String[] mQuestions = {
            "What are the coping strategies employed?"
    };

    /**
     * Constructor
     * @param context
     * @param healthRepositoryManager
     */
    public HealthCopingDataViewModel(Context context, HealthRepositoryManager healthRepositoryManager) {
        super(context, healthRepositoryManager);

        GenericCopingData genericCopingData = mHealthRepositoryManager.getGenericCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genericCopingData.getCopingStrategies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData genericCopingData = new GenericCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get());
        mHealthRepositoryManager.saveGenericCopingData(genericCopingData);
    }
}
