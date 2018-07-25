package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.PsychosocialData;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.PsychosocialDataRow;
import com.cpu.quikdata.ModelsV2.Form.HealthInformation.HealthInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class PsychosocialDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, HealthInformation, GenericEnumDataRow.AgeGroup, PsychosocialDataRow, PsychosocialData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PsychosocialDataViewModel(DNCAFormRepository dncaFormRepository) {
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
        mRowHolder = data.getPsychosocialData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new PsychosocialDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    @Override
    protected void deleteRowFromDb(PsychosocialDataRow row, Realm realm) {
        PsychosocialDataRow rowToDelete = realm.where(PsychosocialDataRow.class).equalTo("id", row.getId()).findFirst();
        try {
            rowToDelete.getGenderTupleFields().deleteAllFromRealm();
            rowToDelete.getStringFields().deleteAllFromRealm();
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
    public void getNewRow(IBaseDataManager<PsychosocialDataRow> callback) {
        PsychosocialDataRow row = new PsychosocialDataRow();
        row.setAgeGroup(typeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, PsychosocialDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelGenderTuple model : row.getGenderTupleFields()) {
            questionList.add(new TemplateQuestionItemViewModelGenderTuple(model));
        }
    }
}
