package com.cpu.quikdata.Modules.NewDnca.Wash.WashConditions;

import android.content.Context;

import com.cpu.quikdata.Models.Wash.WashConditionsData;
import com.cpu.quikdata.Models.Wash.WaterLevelRemarksTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.BaseQuestion;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelLevels;
import com.cpu.quikdata.Modules.NewDnca.Base.QuestionOnlyModules.Questions.QuestionItemViewModelString;
import com.cpu.quikdata.Modules.NewDnca.Wash.WashRepositoryManager;

public class WashConditionsViewModel extends WashBaseViewModel {

    private String[] mQuestions = {
            "What is the current water source and level of water system available?\nDrinking and food preparation:",
            "Bathing, washing and domestic use:",
            "How many water points and conditions are there?",
            "Is the water potable?\n" +
                    "If not, where do they get clean drinking water? (specify distance from the residential units)",
            "How much time do they spend in fetching water?",
            "Who owns the water source?",
            "Do they have to pay for the water? How much per container?",
            "Do they have to pay fare or transportation cost?",
            "Are there particular times there is no water available?",
            "Are there hand washing facilities?",
            "Is there a proper garbage disposal facility?",
            "Is waste segregation observed?",
            "How do women manage issues related to menstruation? Do they use napkins?",
            "How are napkins disposed?",
            "How are baby diapers disposed?",
            "What are the current defecation practices?",
            "What are the toilet facilities available? How many?",
            "What are the conditions of the latrines after the disaster?",
            "Is the current defecation practice a threat to water supplies or living areas?",
            "Are the existing facilities properly maintained?",
            "Are there security and protection issues?",
            "Are the toilets segregated between male and female?",
            "Are the toilets accessible for all (seniors, disabled, children, pregnant, etc)?"
    };

    /**
     * Constructor
     * @param washRepositoryManager
     */
    public WashConditionsViewModel(WashRepositoryManager washRepositoryManager) {
        super(washRepositoryManager);

        WashConditionsData washConditionsData = mWashRepositoryManager.getWashConditionsData();
        mQuestionsViewModels.add(new QuestionItemViewModelLevels(new BaseQuestion(mQuestions[0],
                washConditionsData.getDrinkingLevel().waterLevel, washConditionsData.getDrinkingLevel().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelLevels(new BaseQuestion(mQuestions[1],
                washConditionsData.getBathingLevel().waterLevel, washConditionsData.getBathingLevel().remarks)));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[2],
                washConditionsData.getWaterPointsNumber())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[3],
                washConditionsData.getWaterPotable())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[4],
                washConditionsData.getTimeFetchingWater())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[5],
                washConditionsData.getWaterSourceOwner())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[6],
                washConditionsData.getPayForWater())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[7],
                washConditionsData.getPayForTranspo())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[8],
                washConditionsData.getTimesNoWater())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[9],
                washConditionsData.getHasWashingFacilities())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[10],
                washConditionsData.getHasGarbageDisposal())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[11],
                washConditionsData.getIsWasteSegregated())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[12],
                washConditionsData.getWomenMenstruation())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[13],
                washConditionsData.getNapkinsDisposed())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[14],
                washConditionsData.getDiapersDispoed())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[15],
                washConditionsData.getDefecationPractices())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[16],
                washConditionsData.getToiletFacilities())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[17],
                washConditionsData.getToiletConditions())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[18],
                washConditionsData.getIsDefecationThreat())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[19],
                washConditionsData.getAreFacilitiesMaintained())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[20],
                washConditionsData.getHasSecurityIssues())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[21],
                washConditionsData.getAreToiletsSegregated())));
        mQuestionsViewModels.add(new QuestionItemViewModelString(new BaseQuestion(mQuestions[22],
                washConditionsData.getAreToiletsAccessible())));
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        QuestionItemViewModelLevels drinkingLevelViewModel = (QuestionItemViewModelLevels) mQuestionsViewModels.get(0);
        QuestionItemViewModelLevels bathingLevelViewModel = (QuestionItemViewModelLevels) mQuestionsViewModels.get(1);

        WashConditionsData washConditionsData = new WashConditionsData(
                new WaterLevelRemarksTuple(drinkingLevelViewModel.getActualWaterLevel(), drinkingLevelViewModel.answerRemarks.get()),
                new WaterLevelRemarksTuple(bathingLevelViewModel.getActualWaterLevel(), bathingLevelViewModel.answerRemarks.get()),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(2)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(3)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(4)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(5)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(6)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(7)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(8)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(9)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(10)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(11)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(12)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(13)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(14)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(15)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(16)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(17)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(18)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(19)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(20)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(21)).answer.get(),
                ((QuestionItemViewModelString) mQuestionsViewModels.get(22)).answer.get());
        mWashRepositoryManager.saveWashConditionsData(washConditionsData);
    }
}
