package com.cpu.quikdata.ModulesV2.PrefilledData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHousesRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public class PrefilledDataViewModel extends TemplateQuestionViewModel<IPrefilledDataActivity, PrefilledData> {

    private PrefilledData mPrefilledData;

    /**
     * Constructor
     */
    public PrefilledDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getPrefilledData(this);
    }

    /**
     * Handles reception of prefilled data
     * @param data
     */
    @Override
    public void onDataReceived(PrefilledData data) {
        mPrefilledData = data;

        // Baseline Population
        for (BaselinePopulationRow row : mPrefilledData.getBaselinePopulation().getRows()) {
            mQuestions.add(new QuestionItemModelGenderTuple(row.getAgeGroup().toString(),
                    row.getMale(),
                    row.getFemale()));
        }

        // Families and Households
        mQuestions.add(new QuestionItemModelSingleNumber("Families", mPrefilledData.getBaselineFamilies().getFamilies()));
        mQuestions.add(new QuestionItemModelSingleNumber("Households", mPrefilledData.getBaselineFamilies().getHouseholds()));

        // Baseline Houses
        for (BaselineHousesRow house : mPrefilledData.getBaselineHouses().getHouses()) {
            mQuestions.add(new QuestionItemModelSingleNumber(house.getHouseType(), house.getNumber()));
        }
    }
}
