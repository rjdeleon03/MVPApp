package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.SpecialNeedsData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.SpecialNeedsDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class SpecialNeedsDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, HealthInformation, GenericEnumDataRow.SpecialNeedsType, SpecialNeedsDataRow, SpecialNeedsData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public SpecialNeedsDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.SpecialNeedsType.asObservableList();
        mFormRepository.getHealthInformation(this);
    }

    /**
     * Handles processing of received health information data
     * @param data
     */
    @Override
    protected void processReceivedData(HealthInformation data) {
        mRowHolder = data.getSpecialNeedsData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new SpecialNeedsDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<SpecialNeedsDataRow> callback) {
        SpecialNeedsDataRow row = new SpecialNeedsDataRow();
        row.setSpecialNeedsType(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, SpecialNeedsDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
        for(QuestionItemModelString model : row.getStringFields()) {
            questionList.add(new TemplateQuestionItemViewModelString(model));
        }
    }
}
