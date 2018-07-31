package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsData;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterNeedsDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
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

public class ShelterNeedsDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, ShelterInformation, GenericEnumDataRow.NeedsType, ShelterNeedsDataRow, ShelterNeedsData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ShelterNeedsDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.NeedsType.asObservableList();
        mFormRepository.getShelterInformation(this);
    }

    /**
     * Handles processing of received shelter information data
     * @param data
     */
    @Override
    protected void processReceivedData(ShelterInformation data) {
        mRowHolder = data.getShelterNeedsData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new ShelterNeedsDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<ShelterNeedsDataRow> callback) {
        ShelterNeedsDataRow row = new ShelterNeedsDataRow();
        row.setNeedsType(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, ShelterNeedsDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelString model : row.getStringFields()) {
            questionList.add(new TemplateQuestionItemViewModelString(model));
        }

        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
    }
}
