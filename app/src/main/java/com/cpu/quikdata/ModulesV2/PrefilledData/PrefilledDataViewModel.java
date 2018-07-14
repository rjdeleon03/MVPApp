package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.databinding.Bindable;
import android.support.v7.widget.RecyclerView;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHousesRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateItemAdapter;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewModel.TemplateQuestionViewModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PrefilledDataViewModel extends TemplateQuestionViewModel<IPrefilledDataActivity, PrefilledData> {

    private PrefilledData mPrefilledData;

    private List<QuestionItemModel> mQuestions = new ArrayList<>();

    /**
     * Constructor
     */
    public PrefilledDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getPrefilledData(this);
        mAdapter = new TemplateItemAdapter(this);
    }

    @Override
    public void setActivity(IPrefilledDataActivity activity) {
        mActivity = new WeakReference<>(activity);
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
    public RecyclerView.Adapter getAdapter() {
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
