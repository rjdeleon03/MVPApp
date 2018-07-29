package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import android.databinding.Bindable;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.BR;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationCenterDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationFacilitiesDetails;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationInfoList;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationItem;
import com.cpu.quikdata.ModelsV2.Form.EvacuationInformation.EvacuationPopulationData;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class EvacuationInfoListViewModel
        extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, EvacuationInfoList, GenericEnumDataRow.EvacuationType, EvacuationItem, EvacuationInfoList> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public EvacuationInfoListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getEvacuationInfoList(this);
    }

    /**
     * Handles data reception
     * @param data
     */
    @Override
    public void onDataReceived(EvacuationInfoList data) {
        processReceivedData(data);
    }

    /**
     * Handles processing of received evacuation information data
     * @param data
     */
    @Override
    protected void processReceivedData(EvacuationInfoList data) {
        mRowHolder = data;
    }

    /**
     * Sets up the adapter
     */
    @Override
    public void setupAdapter() {
        mRowAdapter = new EvacuationInfoListRowAdapter(mViewComponent.get(),this);
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
    public void saveRow(final EvacuationItem row) {
        RealmList<EvacuationItem> rows = mRowHolder.getRows();
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
        final EvacuationItem row = mRowHolder.getRows().get(rowIndex);

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
    protected void deleteRowFromDb(EvacuationItem row, Realm realm) {
        EvacuationItem rowToDelete = realm.where(EvacuationItem.class).equalTo("id", row.getId()).findFirst();
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
    public void getNewRow(final IBaseDataManager<EvacuationItem> callback) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                EvacuationItem row = realm.createObject(EvacuationItem.class, AppUtil.generateId());

                EvacuationCenterDetails evacuationCenterDetails = realm.createObject(EvacuationCenterDetails.class, AppUtil.generateId());
                row.setEvacuationCenterDetails(evacuationCenterDetails);

                EvacuationFacilitiesDetails evacuationFacilitiesDetails = realm.createObject(EvacuationFacilitiesDetails.class, AppUtil.generateId());
                row.setEvacuationFacilitiesDetails(evacuationFacilitiesDetails);

                EvacuationPopulationData evacuationPopulationData = realm.createObject(EvacuationPopulationData.class, AppUtil.generateId());
                row.setEvacuationPopulationData(evacuationPopulationData);

                callback.onDataReceived(realm.copyFromRealm(row));
            }
        });
    }

    /**
     * Gets question based on the selected row
     * @param questionList
     * @param row
     */
    @Override
    public void generateQuestions(List<TemplateQuestionItemViewModel> questionList, EvacuationItem row) {
        if (questionList == null) return;

//        for(QuestionItemModelGenderTuple model : row.getGenderTupleFields()) {
//            questionList.add(new TemplateQuestionItemViewModelGenderTuple(model));
//        }
    }
}
