package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationFacilitiesData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationFacilitiesData;
import com.cpu.quikdata.Models.Generics.BoolIntTuple;
import com.cpu.quikdata.Models.Generics.BoolRemarksTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelInt;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class EvacuationFacilitiesDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "Accommodation Capacity of the Evacuation Center or Temporary Shelter:",
            "Toilet(s)",
            "Wide Entrance/Exit",
            "Electricity",
            "Water Supply",
            "Proper Ventilation"
    };

    /**
     * Constructor
     * @param evacuationItemRepositoryManager
     */
    public EvacuationFacilitiesDataViewModel(EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(evacuationItemRepositoryManager);

        EvacuationFacilitiesData facilitiesData = mEvacuationItemRepositoryManager.getFacilitiesData();
        mQuestionsViewModels.add(new QuestionItemViewModelInt(new BaseQuestion(mQuestions[0], facilitiesData.getCapacity())));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[1], facilitiesData.getToilets().isYes), facilitiesData.getToilets().remarks, "Number of Toilets"));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2], facilitiesData.getWideEntrance().isYes), facilitiesData.getWideEntrance().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[3], facilitiesData.getElectricity().isYes), facilitiesData.getElectricity().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[4], facilitiesData.getWaterSupply().isYes), facilitiesData.getWaterSupply().remarks));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[5], facilitiesData.getProperVentilation().isYes), facilitiesData.getProperVentilation().remarks));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        List<QuestionItemViewModelBoolean> booleansList = new ArrayList<>();
        for (int i = 1; i < mQuestionsViewModels.size(); i++) {
            booleansList.add((QuestionItemViewModelBoolean) mQuestionsViewModels.get(i));
        }

        EvacuationFacilitiesData facilitiesData = new EvacuationFacilitiesData(
                ((QuestionItemViewModelInt) mQuestionsViewModels.get(0)).answer.get(),
                new BoolIntTuple(booleansList.get(0).answer.get(), booleansList.get(0).remarksInt.get()),
                new BoolRemarksTuple(booleansList.get(1).answer.get(), booleansList.get(1).remarks.get()),
                new BoolRemarksTuple(booleansList.get(2).answer.get(), booleansList.get(2).remarks.get()),
                new BoolRemarksTuple(booleansList.get(3).answer.get(), booleansList.get(3).remarks.get()),
                new BoolRemarksTuple(booleansList.get(4).answer.get(), booleansList.get(4).remarks.get()));

        mEvacuationItemRepositoryManager.saveFacilitiesData(facilitiesData);
    }
}
