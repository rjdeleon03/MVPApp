package com.cpu.quikdata.ModulesV2.PrefilledData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHousesRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelTextOnly;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

import com.cpu.quikdata.BR;

import io.realm.Realm;

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
        mQuestions.add(new TemplateQuestionItemViewModelTextOnly(new QuestionItemModelTextOnly("populationTitle")));
        for (BaselinePopulationRow row : mPrefilledData.getPopulation()) {
            mQuestions.add(new TemplateQuestionItemViewModelGenderTuple(row.getCount()));
        }

        // Families and Households
        mQuestions.add(new TemplateQuestionItemViewModelTextOnly(new QuestionItemModelTextOnly("familiesTitle")));
        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(mPrefilledData.getFamilyCount()));
        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(mPrefilledData.getHouseholdsCount()));

        // Baseline Houses
        mQuestions.add(new TemplateQuestionItemViewModelTextOnly(new QuestionItemModelTextOnly("housesTitle")));
        for (BaselineHousesRow house : mPrefilledData.getHouses()) {
            mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(house.getCount()));
        }
        notifyPropertyChanged(BR.questions);
    }

    @Override
    public void onViewPaused() {
        super.onViewPaused();
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(mPrefilledData);
            }
        });
    }
}
