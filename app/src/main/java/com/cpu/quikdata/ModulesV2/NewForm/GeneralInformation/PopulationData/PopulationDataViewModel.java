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

public class PopulationDataViewModel extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, GeneralInformation, GenericEnumDataRow.AgeGroup, PopulationDataRow>
        implements ITemplateEnumDataManager<PopulationDataRow> {

    private PopulationData mPopulationData;

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
        return mPopulationData.getRows();
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
        mPopulationData = data.getPopulationData();
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
        callback.onDataReceived(mPopulationData.getRows().get(rowIndex));
    }

    /**
     * Gets the number of rows
     * @return
     */
    @Override
    public int getRowsCount() {
        return mPopulationData.getRows().size();
    }

    /**
     * Saves the row
     * @param row
     */
    @Override
    public void saveRow(final PopulationDataRow row) {

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {

                RealmList<PopulationDataRow> rows = mPopulationData.getRows();

                // If list is empty, add new row right away
                if (rows.size() == 0 ) {
                    realm.insert(row);
                    rows.add(row);

                } else {

                    // Else, select correct position
                    for (int i = 0; i < rows.size(); i++) {

                        PopulationDataRow currRow = rows.get(i);
                        int currAgeGroupOrdinal = GenericEnumDataRow.AgeGroup.valueOf(currRow.getAgeGroup()).getOrdinal();
                        int tempAgeGroupOrdinal = GenericEnumDataRow.AgeGroup.valueOf(row.getAgeGroup()).getOrdinal();

                        if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                            // TODO: add abstract function for copying one enum row to another
                            // If age group already exists, update its values
//                            rows.set(i, row);
                            currRow.setAffectedMale(row.getAffectedMale());
                            currRow.setAffectedFemale(row.getAffectedFemale());
                            currRow.setDisplacedMale(row.getDisplacedMale());
                            currRow.setDisplacedFemale(row.getDisplacedFemale());
                            realm.insertOrUpdate(currRow);
                            break;

                        } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                                (i == 0 || tempAgeGroupOrdinal > GenericEnumDataRow.AgeGroup.valueOf(rows.get(i - 1).getAgeGroup()).getOrdinal())) {

                            // If row must be inserted somewhere in the middle, find its correct position
                            realm.insert(row);
                            break;

                        } else if (rows.size() == i + 1) {

                            // If end of list has been reached, add row
                            realm.insert(row);
                            rows.add(row);
                            break;

                        }
                    }
                }

                realm.insertOrUpdate(mPopulationData);
                notifyPropertyChanged(BR.rowList);

                // Delete age group from list
                for(GenericEnum type : mTypeList) {
                    if (type.getOrdinal() == GenericEnumDataRow.AgeGroup.valueOf(row.getAgeGroup()).getOrdinal()) {
                        mTypeList.remove(type);
                        notifyPropertyChanged(BR.typeList);
                        notifyPropertyChanged(BR.shouldShowSpinner);
                        return;
                    }
                }
            }
        });

        /*
        /
         */
    }

    @Override
    public void selectedRowAtIndex(int rowIndex) {
        if (mViewComponent.get() != null) {
            mViewComponent.get().onCardSelected(rowIndex);
        }
    }

    @Override
    public void deletedRowAtIndex(int rowIndex) {

    }
}
