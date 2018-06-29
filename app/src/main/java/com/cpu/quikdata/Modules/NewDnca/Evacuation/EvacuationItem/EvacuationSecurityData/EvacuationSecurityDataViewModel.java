package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSecurityData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationSecurityData;
import com.cpu.quikdata.Models.Generics.BoolIntTuple;
import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class EvacuationSecurityDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "Unaccompanied Children",
            "Locks for Toilet/ Bath",
            "Segregated Toilet/ Bath for Men and Women",
            "Proper Lighting Condition",
            "Security Officers",
            "Partitions for Sleeping",
            "Child-friendly Space",
            "Safe Space for Pregnant & Lactating Mothers",
            "Safe Space for Persons with Disability",
            "Space for Religious Practices",
            "Is there a referral pathway for incidents of Gender Based Violence (GBV)?",
            "Are there GBV protection services available?",
            "Is there GBV protection focal point?"
    };

    /**
     * Constructor
     * @param evacuationItemRepositoryManager
     */
    public EvacuationSecurityDataViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(evacuationItemRepositoryManager);

        EvacuationSecurityData securityData = mEvacuationItemRepositoryManager.getSecurityData();
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[0], securityData.getUnaccompaniedChildren().isYes), securityData.getUnaccompaniedChildren().remarks, "Number of Unaccompanied Children"));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1], securityData.getToiletLocks().isYes), securityData.getToiletLocks().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2], securityData.getSegregatedToilet().isYes), securityData.getSegregatedToilet().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3], securityData.getProperLighting().isYes), securityData.getProperLighting().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[4], securityData.getSecurityOfficers().isYes), securityData.getSecurityOfficers().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[5], securityData.getSleepingPartitions().isYes), securityData.getSleepingPartitions().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[6], securityData.getChildFriendlySpace().isYes), securityData.getChildFriendlySpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[7], securityData.getPregnantSafeSpace().isYes), securityData.getPregnantSafeSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[8], securityData.getDisabledSafeSpace().isYes), securityData.getDisabledSafeSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[9], securityData.getReligiousSpace().isYes), securityData.getReligiousSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[10], securityData.getGbvReferral().isYes), securityData.getGbvReferral().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[11], securityData.getGbvProtection().isYes), securityData.getGbvProtection().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[12], securityData.getGbvFocalPoint().isYes), securityData.getGbvFocalPoint().remarks));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        List<QuestionItemViewModelBoolean> booleansList = new ArrayList<>();
        for (int i = 0; i < mQuestionsViewModels.size(); i++) {
            booleansList.add((QuestionItemViewModelBoolean) mQuestionsViewModels.get(i));
        }

        EvacuationSecurityData securityData = new EvacuationSecurityData(
                new BoolIntTuple(booleansList.get(0).answer.get(), booleansList.get(0).remarksInt.get()),
                new BoolRemarksTuple(booleansList.get(1).answer.get(), booleansList.get(1).remarks.get()),
                new BoolRemarksTuple(booleansList.get(2).answer.get(), booleansList.get(2).remarks.get()),
                new BoolRemarksTuple(booleansList.get(3).answer.get(), booleansList.get(3).remarks.get()),
                new BoolRemarksTuple(booleansList.get(4).answer.get(), booleansList.get(4).remarks.get()),
                new BoolRemarksTuple(booleansList.get(5).answer.get(), booleansList.get(5).remarks.get()),
                new BoolRemarksTuple(booleansList.get(6).answer.get(), booleansList.get(6).remarks.get()),
                new BoolRemarksTuple(booleansList.get(7).answer.get(), booleansList.get(7).remarks.get()),
                new BoolRemarksTuple(booleansList.get(8).answer.get(), booleansList.get(8).remarks.get()),
                new BoolRemarksTuple(booleansList.get(9).answer.get(), booleansList.get(9).remarks.get()),
                new BoolRemarksTuple(booleansList.get(10).answer.get(), booleansList.get(10).remarks.get()),
                new BoolRemarksTuple(booleansList.get(11).answer.get(), booleansList.get(11).remarks.get()),
                new BoolRemarksTuple(booleansList.get(12).answer.get(), booleansList.get(12).remarks.get()));

        mEvacuationItemRepositoryManager.saveSecurityData(securityData);
    }
}
