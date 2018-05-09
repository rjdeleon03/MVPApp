package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulationDataViewModel extends NewDncaBaseViewModel implements DNCAFormDataSource.GetDncaFormCallback, PopulationDataRootViewModel {

    private PopulationDataNavigator mPopulationDataNavigator;
    private List<PopulationData.AgeGroup> mAgeGroupList;
    private List<PopulationDataRow> mPopulationDataRows;
    private DNCAFormRepository mDncaFormRepository;

    public ObservableInt spinnerValue;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public PopulationDataViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        super(context);
        spinnerValue = new ObservableInt(0);
        mAgeGroupList = PopulationData.AgeGroup.asList();
        mPopulationDataRows = new ArrayList<>();
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.retrieveNewDncaForm(this);
    }

    /**
     * Set population data navigator
     * @param populationDataNavigator
     */
    public void setPopulationDataNavigator(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
    }

    /**
     * Retrieves list of age group
     */
    public List<PopulationData.AgeGroup> getAgeGroupList() {
        return mAgeGroupList;
    }

    /**
     * Retrieves population data rows count
     * @return
     */
    public int getPopulationDataRowsCount() {
        return mPopulationDataRows.size();
    }

    /**
     * Called when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        mPopulationDataNavigator.onAddButtonPressed();
    }

    /**
     * Add population data row
     * @param populationDataRow
     */
    @Override
    public void addPopulationDataRow(PopulationDataRow populationDataRow) {

        // If list is empty, add new row right away
        if (mPopulationDataRows.size() == 0) {
            mPopulationDataRows.add(populationDataRow);

        } else {

            // Else, select correct position
            for (int i = 0; i < mPopulationDataRows.size(); i++) {

                PopulationDataRow row = mPopulationDataRows.get(i);
                int currAgeGroupOrdinal = row.getAgeGroup().ordinal();
                int tempAgeGroupOrdinal = populationDataRow.getAgeGroup().ordinal();

                if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                    // If age group already exists, update its values
                    row.setAgeGroup(populationDataRow.getAgeGroup());
                    row.setTotal(populationDataRow.getTotal());
                    row.setAffected(populationDataRow.getAffected());
                    row.setDisplaced(populationDataRow.getDisplaced());
                    break;

                } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        tempAgeGroupOrdinal > mPopulationDataRows.get(i - 1).getAgeGroup().ordinal()) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    mPopulationDataRows.add(i, populationDataRow);
                    break;

                } else if (mPopulationDataRows.size() == i + 1) {

                    // If end of list has been reached, add row
                    mPopulationDataRows.add(populationDataRow);
                    break;

                }
            }
        }

        // Delete age group from list
        for(PopulationData.AgeGroup ageGroup : mAgeGroupList) {
            if (ageGroup.ordinal() == populationDataRow.getAgeGroup().ordinal()) {
                mAgeGroupList.remove(ageGroup);
                return;
            }
        }

    }

    /**
     * Get population data row
     * @param rowIndex
     */
    @Override
    public PopulationDataRow getPopulationDataRow(int rowIndex) {
        return mPopulationDataRows.get(rowIndex);
    }

    /**
     * Get age group based on index
     * @param ageGroupIndex
     * @return
     */
    @Override
    public PopulationData.AgeGroup getPopulationDataAgeGroup(int ageGroupIndex) {
        return mAgeGroupList.get(ageGroupIndex);
    }

    @Override
    public void onDncaFormLoaded(DNCAForm form) {
        if (mPopulationDataRows.size() > 0) {
            mPopulationDataRows.clear();
        }
        mPopulationDataRows.addAll(form.getGenInfo().getPopulationData().getPopulationDataRows());
    }

    @Override
    public void onDataNotAvailable() {

    }
}
