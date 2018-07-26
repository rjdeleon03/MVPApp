package com.cpu.quikdata.ModulesV2.NewForm.Common;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class AssistanceDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, ShelterInformation, GenericEnumDataRow.AssistanceType, AssistanceDataRow, AssistanceData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public AssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        typeList = GenericEnumDataRow.AssistanceType.asObservableList();
        mFormRepository.getShelterInformation(this);
    }

    /**
     * Handles processing of received general information data
     * @param data
     */
    @Override
    protected void processReceivedData(ShelterInformation data) {
        mRowHolder = data.getAssistanceData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new AssistanceDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    @Override
    protected void deleteRowFromDb(AssistanceDataRow row, Realm realm) {
        AssistanceDataRow rowToDelete = realm.where(AssistanceDataRow.class).equalTo("id", row.getId()).findFirst();
        try {
//            rowToDelete.getGenderTupleFields().deleteAllFromRealm();
            rowToDelete.deleteFromRealm();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<AssistanceDataRow> callback) {
        AssistanceDataRow row = new AssistanceDataRow();
//        row.setAssistanceType(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, AssistanceDataRow row) {
        if (questionList == null) return;

//        for(QuestionItemModelGenderTuple model : row.getGenderTupleFields()) {
//            questionList.add(new TemplateQuestionItemViewModelGenderTuple(model));
//        }
    }
}
