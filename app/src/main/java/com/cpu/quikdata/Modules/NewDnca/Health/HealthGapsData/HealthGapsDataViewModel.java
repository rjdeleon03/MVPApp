package com.cpu.quikdata.Modules.NewDnca.Health.HealthGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Health.HealthGapsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.HealthRepositoryManager;

public class HealthGapsDataViewModel extends HealthBaseViewModel {

    private String[] mQuestions = {
            "Where/what is the nearest hospital in the area (public/private)?",
            "What services are available within the community?",
            "Are these accessible to and sufficient for the target population?",
            "Are there specific services for reproductive health?"
    };

    /**
     * Constructor
     * @param context
     * @param healthRepositoryManager
     */
    public HealthGapsDataViewModel(Context context, HealthRepositoryManager healthRepositoryManager) {
        super(context, healthRepositoryManager);

        HealthGapsData healthGapsData = mHealthRepositoryManager.getHealthGapsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], healthGapsData.getNearestHospital())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], healthGapsData.getServicesAvailable())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], healthGapsData.getServicesAcessibility())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], healthGapsData.getRepHealthServices())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        HealthGapsData healthGapsData = new HealthGapsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get());
        mHealthRepositoryManager.saveHealthGapsData(healthGapsData);
    }
}
