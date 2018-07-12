package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.Models.QuestionItemModelSingleNumber;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TemplateQuestionViewModel extends BaseObservable implements IPrefilledDataManager {

    @Nullable
    private WeakReference<IPrefilledDataActivity> mIPrefilledDataActivity;

    private DNCAFormRepository mFormRepository;
    private PrefilledData mPrefilledData;
    private TemplateItemAdapter mAdapter;

    private List<QuestionItemModel> mQuestions = new ArrayList<>();

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

        // Baseline Population
        for (BaselinePopulationRow row : mPrefilledData.getBaselinePopulation().getRows()) {
            mQuestions.add(new QuestionItemModelGenderTuple(row.getAgeGroup().toString(),
                    row.getMale(),
                    row.getFemale()));
        }

        // Families and Households
        mQuestions.add(new QuestionItemModelSingleNumber("Families", mPrefilledData.getBaselineFamilies().getFamilies()));
        mQuestions.add(new QuestionItemModelSingleNumber("Households", mPrefilledData.getBaselineFamilies().getHouseholds()));
    }

    /**
     * Gets the questions
     * @return
     */
    @Bindable
    @Override
    public List<QuestionItemModel> getQuestions() {
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
        return mQuestions.size();
    }
}
