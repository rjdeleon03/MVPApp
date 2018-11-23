package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.DiseasesData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.DiseasesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class DiseasesDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, HealthInformation, GenericEnumDataRow.AgeGroup, DiseasesDataRow, DiseasesData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DiseasesDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.AgeGroup.asObservableList();
        mFormRepository.getHealthInformation(this);
    }

    /**
     * Handles processing of received health information data
     * @param data
     */
    @Override
    protected void processReceivedData(HealthInformation data) {
        mRowHolder = data.getDiseasesData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new DiseasesDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<DiseasesDataRow> callback) {
        DiseasesDataRow row = new DiseasesDataRow();
        row.setAgeGroup(typeList.get(spinnerSelectedIndex.get()).toNormalString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, DiseasesDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelGenderTuple model : row.getGenderTupleFields()) {
            questionList.add(new TemplateQuestionItemViewModelGenderTuple(model));
        }
    }
}
