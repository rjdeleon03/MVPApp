package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.Shelter.ShelterGapsData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

public class ShelterGapsDataViewModel extends ShelterInfoBaseViewModel {

    private String[] mQuestions = {
            "Are there any separate cubicles and/or partitions for male and female with the assistance provided?",
            "Is the given assistance appropriate to their cultural practices?",
            "Is the construction of shelter appropriate for its location and size of the family as beneficiaries?",
            "Does it have access to basic services and economic activities?",
            "Are there any able-bodied in the family/community who can participate in resource mobilization, construction of the shelter?",
            "Is there a referral pathway for incidents of Gender Based Violence (GBV)?",
            "Are there GBV protection services available?",
            "Is there GBV protection focal point?"
    };
    
    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterGapsDataViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager);

        ShelterGapsData shelterGapsData = mShelterInfoRepositoryManager.getShelterGapsData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], shelterGapsData.getHasSeparateCubicles())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], shelterGapsData.getIsAssistanceCulturallyAppropriate())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2], shelterGapsData.getIsShelterAppropriate())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3], shelterGapsData.getHasAccessToBasicServices())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[4], shelterGapsData.getHasAbleBodiedMember())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[5], shelterGapsData.getHasReferralPathwayForGbv())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[6], shelterGapsData.getHasGbvProtectionServices())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[7], shelterGapsData.getHasGbvProtectionFocalPoint())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterGapsData shelterGapsData = new ShelterGapsData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(4)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(5)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(7)).answer.get());
        mShelterInfoRepositoryManager.saveShelterGapsData(shelterGapsData);
    }
}
