package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationCopingData;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericCopingData;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationRepositoryManager;

public class EvacuationCopingDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "What are the coping mechanisms or actions of the affected population?"
    };

    /**
     * Constructor
     * @param context
     * @param evacuationRepositoryManager
     */
    public EvacuationCopingDataViewModel(Context context, EvacuationRepositoryManager evacuationRepositoryManager) {
        super(context, evacuationRepositoryManager);

        GenericCopingData genericCopingData = mEvacuationRepositoryManager.getGenericCopingData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], genericCopingData.getCopingStrategies())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        GenericCopingData genericCopingData = new GenericCopingData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get());
        mEvacuationRepositoryManager.saveGenericCopingData(genericCopingData);
    }
}
