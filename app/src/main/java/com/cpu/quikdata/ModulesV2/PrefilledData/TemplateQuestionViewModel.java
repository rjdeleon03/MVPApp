package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulation;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;

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
        BaselinePopulation baselinePopulation = prefilledData.getBaselinePopulation();
    }
}
