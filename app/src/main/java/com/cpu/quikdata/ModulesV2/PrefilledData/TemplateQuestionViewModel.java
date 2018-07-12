package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulation;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.QuestionModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class TemplateQuestionViewModel extends BaseObservable implements IPrefilledDataManager {

    @Nullable
    private WeakReference<IPrefilledDataActivity> mIPrefilledDataActivity;

    private DNCAFormRepository mFormRepository;
    private PrefilledData mPrefilledData;
    private TemplateItemAdapter mAdapter;

    private List<QuestionModel> mQuestions = new ArrayList<>();

    /**
     * Constructor
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        mFormRepository = dncaFormRepository;
        mFormRepository.getPrefilledData(this);
        mAdapter = new TemplateItemAdapter(this);
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
        for (BaselinePopulationRow row : prefilledData.getBaselinePopulation().getRows()) {
            mQuestions.add(new QuestionModel(row.getAgeGroup().toString(),
                    row.getMale(),
                    row.getFemale()));
        }
    }

    /**
     * Gets the questions
     * @return
     */
    @Bindable
    @Override
    public List<QuestionModel> getQuestions() {
        return mQuestions;
    }

    /**
     * Gets the adapter
     * @return
     */
    @Bindable
    @Override
    public TemplateItemAdapter getAdapter() {
        return mAdapter;
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
