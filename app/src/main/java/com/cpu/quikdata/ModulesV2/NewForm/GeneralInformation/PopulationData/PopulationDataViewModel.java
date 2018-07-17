package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.GeneralInformation;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationData;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataViewModel;
import com.cpu.quikdata.ModulesV2.PrefilledData.IBaseDataManager;

import io.realm.Realm;
import io.realm.RealmList;

public class PopulationDataViewModel extends TemplateEnumDataViewModel<ITemplateEnumDataFragment, GeneralInformation, GenericEnumDataRow.AgeGroup> implements IEnumDataManager<PopulationDataRow> {

    private PopulationData mPopulationData;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataViewModel(DNCAFormRepository dncaFormRepository, Context context) {
        super(dncaFormRepository);
        mTypeList = GenericEnumDataRow.AgeGroup.asList();
        mFormRepository.getGeneralInformation(this);
        mAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_spinner_dropdown_item,
                mTypeList);
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
     * Gets all rows
     * @param callback
     */
    @Override
    public void getAllRows(IBaseDataManager<RealmList<PopulationDataRow>> callback) {
        callback.onDataReceived(mPopulationData.getRows());
    }

    /**
     * Saves the row
     * @param row
     */
    @Override
    public void saveRow(final PopulationDataRow row) {
        mFormRepository.insertToDb(row);
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mPopulationData.getRows().add(row);
                realm.insertOrUpdate(mPopulationData);
            }
        });

        /*
        // If list is empty, add new row right away
        if (mGenericEnumDataRows.size() == 0 ) {
            mGenericEnumDataRows.add(genericEnumDataRow);

        } else {

            // Else, select correct position
            for (int i = 0; i < mGenericEnumDataRows.size(); i++) {

                GenericEnumDataRow row = mGenericEnumDataRows.get(i);
                int currAgeGroupOrdinal = row.getType().getOrdinal();
                int tempAgeGroupOrdinal = genericEnumDataRow.getType().getOrdinal();

                if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                    // If age group already exists, update its values
                    mGenericEnumDataRows.set(i, genericEnumDataRow);
                    break;

                } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > mGenericEnumDataRows.get(i - 1).getType().getOrdinal())) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    mGenericEnumDataRows.add(i, genericEnumDataRow);
                    break;

                } else if (mGenericEnumDataRows.size() == i + 1) {

                    // If end of list has been reached, add row
                    mGenericEnumDataRows.add(genericEnumDataRow);
                    break;

                }
            }
        }

        // Delete age group from list
        for(GenericEnum ageGroup : ageGroupList) {
            if (ageGroup.getOrdinal() == genericEnumDataRow.getType().getOrdinal()) {
                ageGroupList.remove(ageGroup);
                return;
            }
        }
         */
    }
}
