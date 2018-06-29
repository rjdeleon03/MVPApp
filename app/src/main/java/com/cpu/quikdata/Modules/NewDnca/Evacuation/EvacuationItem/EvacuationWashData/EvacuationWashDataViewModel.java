package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationWashData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationWashData;
import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class EvacuationWashDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "Clean Space for Food Preparation",
            "Clean Source of Water",
            "Clean Toilet & Baths",
            "Proper Garbage Disposal",
            "Space for Clinic/ Health Workers",
            "Space for the Sick/ Ill",
            "Hand Washing Facilities"
    };

    /**
     * Constructor
     * @param evacuationItemRepositoryManager
     */
    public EvacuationWashDataViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(evacuationItemRepositoryManager);

        EvacuationWashData washData = mEvacuationItemRepositoryManager.getWashData();
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[0], washData.getCleanFoodPrepSpace().isYes), washData.getCleanFoodPrepSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1], washData.getCleanWaterSource().isYes), washData.getCleanWaterSource().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2], washData.getCleanToilets().isYes), washData.getCleanToilets().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3], washData.getGarbageDisposal().isYes), washData.getGarbageDisposal().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[4], washData.getClinicSpace().isYes), washData.getClinicSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[5], washData.getSickSpace().isYes), washData.getSickSpace().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[6], washData.getWashingFacilities().isYes), washData.getWashingFacilities().remarks));
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

        EvacuationWashData washData = new EvacuationWashData(
                new BoolRemarksTuple(booleansList.get(0).answer.get(), booleansList.get(0).remarks.get()),
                new BoolRemarksTuple(booleansList.get(1).answer.get(), booleansList.get(1).remarks.get()),
                new BoolRemarksTuple(booleansList.get(2).answer.get(), booleansList.get(2).remarks.get()),
                new BoolRemarksTuple(booleansList.get(3).answer.get(), booleansList.get(3).remarks.get()),
                new BoolRemarksTuple(booleansList.get(4).answer.get(), booleansList.get(4).remarks.get()),
                new BoolRemarksTuple(booleansList.get(5).answer.get(), booleansList.get(5).remarks.get()),
                new BoolRemarksTuple(booleansList.get(6).answer.get(), booleansList.get(6).remarks.get()));

        mEvacuationItemRepositoryManager.saveWashData(washData);
    }
}
