package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageData;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.DamageDataRow;
import com.cpu.quikdata.ModelsV2.Form.ShelterInformation.ShelterInformation;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;

public class DamageDataViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, ShelterInformation, GenericEnumDataRow.HouseType, DamageDataRow, DamageData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public DamageDataViewModel(DNCAFormRepository dncaFormRepository, Context context) {
        super(dncaFormRepository);
        mTypeList = GenericEnumDataRow.HouseType.asObservableList();
        mFormRepository.getShelterInformation(this);
        mSpinnerAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                mTypeList);
    }

    /**
     * Handles processing of received shelter information data
     * @param data
     */
    @Override
    protected void processReceivedData(ShelterInformation data) {
        mRowHolder = data.getDamageData();
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new DamageDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    @Override
    protected void deleteRowFromDb(DamageDataRow row, Realm realm) {
        DamageDataRow rowToDelete = realm.where(DamageDataRow.class).equalTo("id", row.getId()).findFirst();
        try {
            rowToDelete.getNumberFields().deleteAllFromRealm();
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
    public void getNewRow(IBaseDataManager<DamageDataRow> callback) {
        DamageDataRow row = new DamageDataRow();
        row.setHouseType(mTypeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, DamageDataRow row) {
        if (questionList == null) return;

        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
    }
}
