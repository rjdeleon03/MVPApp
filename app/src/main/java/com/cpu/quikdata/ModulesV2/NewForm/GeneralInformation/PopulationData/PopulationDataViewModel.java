package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import io.realm.Realm;
import io.realm.RealmList;

import com.cpu.quikdata.BR;

import java.util.ArrayList;
import java.util.List;

public class PopulationDataViewModel extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, GeneralInformation, GenericEnumDataRow.AgeGroup, PopulationDataRow, PopulationData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataViewModel(DNCAFormRepository dncaFormRepository, Context context) {
        super(dncaFormRepository);
        mTypeList = GenericEnumDataRow.AgeGroup.asObservableList();
        mFormRepository.getGeneralInformation(this);
        mSpinnerAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                mTypeList);
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new PopulationDataRowAdapter(mViewComponent.get(),this);
    }

    /**
     * Deletes the specified row from the database with the given realm instance
     * @param row
     * @param realm
     */
    @Override
    protected void deleteRowFromDb(PopulationDataRow row, Realm realm) {
        PopulationDataRow rowToDelete = realm.where(PopulationDataRow.class).equalTo("id", row.getId()).findFirst();
        try {
            rowToDelete.deleteFromRealm();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles processing of received general information data
     * @param data
     */
    @Override
    protected void processReceivedData(GeneralInformation data) {
        mRowHolder = data.getPopulationData();
    }

    /**
     * Gets a new row
     * @param callback
     */
    @Override
    public void getNewRow(IBaseDataManager<PopulationDataRow> callback) {
        PopulationDataRow row = new PopulationDataRow();
        row.setAgeGroup(mTypeList.get(spinnerSelectedIndex.get()).toString());
        callback.onDataReceived(row);
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, PopulationDataRow row) {
        if (questionList == null) return;

        questionList.add(new TemplateQuestionItemViewModelGenderTuple(new QuestionItemModelGenderTuple("Affected", row.getAffectedMale(), row.getAffectedFemale())));
        questionList.add(new TemplateQuestionItemViewModelGenderTuple(new QuestionItemModelGenderTuple("Displaced", row.getAffectedMale(), row.getAffectedFemale())));
    }
}
