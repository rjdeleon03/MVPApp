package com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData;

import android.databinding.Bindable;

import com.cpu.quikdata.BR;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceData;
import com.cpu.quikdata.ModelsV2.Form.Common.AssistanceDataRow;
import com.cpu.quikdata.ModelsV2.Form.Common.IAssistanceDataContainer;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public abstract class AssistanceDataViewModel<D extends IAssistanceDataContainer>
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, D, GenericEnumDataRow.AssistanceType, AssistanceDataRow, AssistanceData> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public AssistanceDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles data reception
     * @param data
     */
    @Override
    public void onDataReceived(D data) {
        processReceivedData(data);
    }

    /**
     * Handles processing of received general information data
     * @param data
     */
    @Override
    protected void processReceivedData(D data) {
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
     * Retrieves flag for enabling add button
     * @return
     */
    @Bindable
    public boolean getShouldEnableAddButton() {
        return true;
    }

    /**
     * Handles saving of row
     * @param row
     */
    @Override
    public void saveRow(final AssistanceDataRow row) {
        RealmList<AssistanceDataRow> rows = mRowHolder.getRows();
        if (!rows.contains(row)) {
            rows.add(row);
        }
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(row);
                realm.insertOrUpdate(mRowHolder);
            }
        });

        notifyPropertyChanged(BR.rowList);
    }

    /**
     * Deletes the selected row
     * @param rowIndex
     */
    @Override
    public void deletedRowAtIndex(final int rowIndex) {
        final AssistanceDataRow row = mRowHolder.getRows().get(rowIndex);

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                deleteRowFromDb(row, realm);

                mRowHolder.getRows().remove(rowIndex);
                realm.insertOrUpdate(mRowHolder);
                notifyPropertyChanged(BR.rowList);
            }
        });
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
            rowToDelete.getStringFields().deleteAllFromRealm();
            rowToDelete.getDateFields().deleteAllFromRealm();
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
    public void getNewRow(IBaseDataManager<AssistanceDataRow> callback) {
        AssistanceDataRow row = new AssistanceDataRow();
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

        for(QuestionItemModelString model : row.getStringFields()) {
            questionList.add(new TemplateQuestionItemViewModelString(model));
        }
        for(QuestionItemModelDate model : row.getDateFields()) {
            questionList.add(new TemplateQuestionItemViewModelDate(model));
        }
        for(QuestionItemModelSingleNumber model : row.getNumberFields()) {
            questionList.add(new TemplateQuestionItemViewModelSingleNumber(model));
        }
    }
}
