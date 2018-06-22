package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationSiteData;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationSiteData;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelDate;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelEnum;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelFloat;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelInt;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationItemRepositoryManager;

import java.util.Arrays;

public class EvacuationSiteDataViewModel extends EvacuationBaseViewModel {

    private String[] mQuestions = {
            "Name of Evacuation Center or Temporary Shelter:",
            "Location:",
            "Have the evacuees moved?",
            "Type of Evacuation Center or Temporary Shelter:",
            "Type of Planned Evacuation Center",
            "Is the evacuation center LGU-designated?",
            "Distance from the Community (in Kilometers):",
            "Date of Evacuation:",
            "Size of Evacuation Center (in Square Meters):",
            "How many households and families are staying here?"
    };

    /**
     * Constructor
     * @param context
     * @param evacuationItemRepositoryManager
     */
    public EvacuationSiteDataViewModel(Context context, EvacuationItemRepositoryManager evacuationItemRepositoryManager) {
        super(context, evacuationItemRepositoryManager);

        EvacuationSiteData siteData = mEvacuationItemRepositoryManager.getSiteData();
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[0], siteData.getName())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[1], siteData.getLocation())));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[2], siteData.isDisplaced()), "Displaced", "Non-displaced"));
        mQuestionsViewModels.add(new QuestionItemViewModelEnum(new BaseQuestion(mQuestions[3], siteData.getEvacuationType()), Arrays.asList(EvacuationSiteData.EvacuationType.values())));
        mQuestionsViewModels.add(new QuestionItemViewModelEnum(new BaseQuestion(mQuestions[4], siteData.getPlannedEvacuationType()), Arrays.asList(EvacuationSiteData.PlannedEvacuationType.values())));
        mQuestionsViewModels.add(new QuestionItemViewModelBoolean(new BaseQuestion(mQuestions[5], siteData.isLguDesignated())));
        mQuestionsViewModels.add(new QuestionItemViewModelFloat(new BaseQuestion(mQuestions[6], siteData.getCommunityDistance())));
        mQuestionsViewModels.add(new QuestionItemViewModelDate(new BaseQuestion(mQuestions[7], siteData.getEvacuationDate())));
        mQuestionsViewModels.add(new QuestionItemViewModelFloat(new BaseQuestion(mQuestions[8], siteData.getShelterSize())));
        mQuestionsViewModels.add(new QuestionItemViewModelInt(new BaseQuestion(mQuestions[9], siteData.getFamiliesCount())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        EvacuationSiteData siteData = new EvacuationSiteData(
                ((QuestionItemViewModelString) mQuestionsViewModels.get(0)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(1)).answer.get(),
                ((QuestionItemViewModelBoolean) mQuestionsViewModels.get(2)).answer.get(),
                (EvacuationSiteData.EvacuationType) ((QuestionItemViewModelEnum) mQuestionsViewModels.get(3)).getEnumAnswer(),
                (EvacuationSiteData.PlannedEvacuationType) ((QuestionItemViewModelEnum) mQuestionsViewModels.get(4)).getEnumAnswer(),
                ((QuestionItemViewModelBoolean) mQuestionsViewModels.get(5)).answer.get(),
                ((QuestionItemViewModelFloat) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelDate) mQuestionsViewModels.get(7)).answer.get(),
                ((QuestionItemViewModelFloat) mQuestionsViewModels.get(8)).answer.get(),
                ((QuestionItemViewModelInt) mQuestionsViewModels.get(9)).answer.get());
        mEvacuationItemRepositoryManager.saveSiteData(siteData);
    }
}
