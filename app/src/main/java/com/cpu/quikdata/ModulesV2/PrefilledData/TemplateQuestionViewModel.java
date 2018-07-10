package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulation;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

import java.lang.ref.WeakReference;

public class TemplateQuestionViewModel implements IPrefilledDataManager {

    @Nullable
    private WeakReference<IPrefilledDataActivity> mIPrefilledDataActivity;

    private DNCAFormRepository mFormRepository;
    private PrefilledData mPrefilledData;

    /**
     * Constructor
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
        mFormRepository.getPrefilledData(this);
    }

    /**
     * Sets the form list activity interface
     * @param iPrefilledDataActivity
     */
    public void setActivity(IPrefilledDataActivity iPrefilledDataActivity) {
        mIPrefilledDataActivity = new WeakReference<>(iPrefilledDataActivity);
    }

    /**
     * Handles reception of prefilled data
     * @param prefilledData
     */
    @Override
    public void onPrefilledDataRetrieved(PrefilledData prefilledData) {
        mPrefilledData = prefilledData;
    }

    /**
     * Gets question viewModel
     * @param index
     * @return
     */
    @Override
    public QuestionModel getQuestionModel(int index) {
        BaselinePopulationRow row = mPrefilledData.getBaselinePopulation().getRows().get(index);
        return new QuestionModel(row.getAgeGroup(), row.getMale(), row.getFemale());
    }

    /**
     * Gets number of question items
     * @return
     */
    @Override
    public int getItemsCount() {
        return mPrefilledData.getBaselinePopulation().getRows().size();
    }
}
