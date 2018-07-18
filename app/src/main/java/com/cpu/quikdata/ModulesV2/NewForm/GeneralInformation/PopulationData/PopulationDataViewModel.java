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
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import io.realm.Realm;
import io.realm.RealmList;

import com.cpu.quikdata.BR;

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
     * Retrieves the list of rows
     * @return
     */
    @Override
    public List<PopulationDataRow> getRowList() {
        return mRowHolder.getRows();
    }

    /**
     * Retrieves flag for showing spinner
     * @return
     */
    @Override
    public boolean getShouldShowSpinner() {
        return mTypeList.size() > 0;
    }

    /**
     * Handles reception of general information data
     * @param data
     */
    @Override
    public void onDataReceived(GeneralInformation data) {
        mRowHolder = data.getPopulationData();
        updateTypeList();
    }

    /**
     * Updates the age group list
     */
    protected void updateTypeList() {

        // Remove items from type list if type is already in use
        for (PopulationDataRow row : mRowHolder.getRows()) {
            for (GenericEnum ageGroup : mTypeList) {
                if (ageGroup.getOrdinal() == row.getActualType().getOrdinal()) {
                    mTypeList.remove(ageGroup);
                    break;
                }
            }
        }
        notifyPropertyChanged(BR.typeList);
        notifyPropertyChanged(BR.shouldShowSpinner);
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
     * Gets row at the specified index
     * @param callback
     * @param rowIndex
     */
    @Override
    public void getRowAtIndex(IBaseDataManager<PopulationDataRow> callback, int rowIndex) {
        callback.onDataReceived(mRowHolder.getRows().get(rowIndex));
    }

    /**
     * Gets the number of rows
     * @return
     */
    @Override
    public int getRowsCount() {
        return mRowHolder.getRows().size();
    }

    /**
     * Opens the selected row for editing
     * @param rowIndex
     */
    @Override
    public void selectedRowAtIndex(int rowIndex) {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onCardSelected(rowIndex);
        }
    }

    /**
     * Deletes the selected row
     * @param rowIndex
     */
    @Override
    public void deletedRowAtIndex(final int rowIndex) {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PopulationDataRow row = mRowHolder.getRows().get(rowIndex);
                if (row == null) return;

                GenericEnumDataRow.AgeGroup type = row.getActualType();

                // If list is empty, add new row right away
                if (mTypeList.size() == 0) {
                    mTypeList.add(type);

                } else {

                    // Else, select correct position
                    for (int i = 0; i < mTypeList.size(); i++) {

                        int currAgeGroupOrdinal = mTypeList.get(i).getOrdinal();
                        int tempAgeGroupOrdinal = type.getOrdinal();

                        if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                                (i == 0 || tempAgeGroupOrdinal > mTypeList.get(i - 1).getOrdinal())) {

                            // If row must be inserted somewhere in the middle, find its correct position
                            mTypeList.add(i, type);
                            break;

                        } else if (mTypeList.size() == i + 1) {

                            // If end of list has been reached, add row
                            mTypeList.add(type);
                            break;

                        }
                    }
                }


                PopulationDataRow rowToDelete = realm.where(PopulationDataRow.class).equalTo("id", row.getId()).findFirst();
                try {
                    rowToDelete.deleteFromRealm();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                mRowHolder.getRows().remove(rowIndex);
                realm.insertOrUpdate(mRowHolder);
                notifyPropertyChanged(BR.rowList);
                notifyPropertyChanged(BR.typeList);
                notifyPropertyChanged(BR.shouldShowSpinner);
            }
        });
    }
}
