package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationPopulationData;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationPopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.IEvacuationItemDataManager;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class EvacuationPopulationDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, EvacuationItem, GenericEnumDataRow.AgeGroup, EvacuationPopulationDataRow, EvacuationPopulationData> {

    private IEvacuationItemDataManager mDataManager;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationPopulationDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.AgeGroup.asObservableList();
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(IEvacuationItemDataManager dataManager) {
        mDataManager = dataManager;
        mDataManager.getRow(this);
    }

    /**
     * Handles processing of received general information data
     * @param data
     */
    @Override
    protected void processReceivedData(EvacuationItem data) {
        mRowHolder = data.getEvacuationPopulationData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new EvacuationPopulationDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<EvacuationPopulationDataRow> callback) {
        EvacuationPopulationDataRow row = new EvacuationPopulationDataRow();
        row.setAgeGroup(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, EvacuationPopulationDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
    }
}
