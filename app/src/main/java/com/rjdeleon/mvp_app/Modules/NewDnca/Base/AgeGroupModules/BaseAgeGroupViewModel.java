package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgeGroupViewModel extends NewDncaGenInfoBaseViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected List<AgeGroupDataRow.AgeGroup> mAgeGroupList = AgeGroupDataRow.AgeGroup.asList();
    protected List<AgeGroupDataRow> mAgeGroupDataRows = new ArrayList<>();

    public ObservableInt spinnerValue = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    protected BaseAgeGroupViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);

        // Remove items from age group list if age group is already in use
        for(AgeGroupDataRow row : mAgeGroupDataRows) {
            for (AgeGroupDataRow.AgeGroup ageGroup : mAgeGroupList) {
                if (ageGroup.ordinal() == row.getAgeGroup().ordinal()) {
                    mAgeGroupList.remove(ageGroup);
                    break;
                }
            }
        }
    }

    /**
     * Adds age group data row
     * @param ageGroupDataRow
     */
    protected void addAgeGroupDataRow(AgeGroupDataRow ageGroupDataRow) {

        // If list is empty, add new row right away
        if (mAgeGroupDataRows.size() == 0) {
            mAgeGroupDataRows.add(ageGroupDataRow);

        } else {

            // Else, select correct position
            for (int i = 0; i < mAgeGroupDataRows.size(); i++) {

                AgeGroupDataRow row = mAgeGroupDataRows.get(i);
                int currAgeGroupOrdinal = row.getAgeGroup().ordinal();
                int tempAgeGroupOrdinal = ageGroupDataRow.getAgeGroup().ordinal();

                if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                    // If age group already exists, update its values
                    mAgeGroupDataRows.set(i, ageGroupDataRow);
                    break;

                } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > mAgeGroupDataRows.get(i - 1).getAgeGroup().ordinal())) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    mAgeGroupDataRows.add(i, ageGroupDataRow);
                    break;

                } else if (mAgeGroupDataRows.size() == i + 1) {

                    // If end of list has been reached, add row
                    mAgeGroupDataRows.add(ageGroupDataRow);
                    break;

                }
            }
        }

        // Delete age group from list
        for(AgeGroupDataRow.AgeGroup ageGroup : mAgeGroupList) {
            if (ageGroup.ordinal() == ageGroupDataRow.getAgeGroup().ordinal()) {
                mAgeGroupList.remove(ageGroup);
                return;
            }
        }

    }

    /**
     * Deletes age group data row
     * @param rowIndex
     */
    protected void deletePopulationDataRow(int rowIndex) {

        AgeGroupDataRow ageGroupDataRow = mAgeGroupDataRows.get(rowIndex);

        // If list is empty, add new row right away
        if (mAgeGroupList.size() == 0) {
            mAgeGroupList.add(ageGroupDataRow.getAgeGroup());

        } else {

            // Else, select correct position
            for (int i = 0; i < mAgeGroupList.size(); i++) {

                int currAgeGroupOrdinal = mAgeGroupList.get(i).ordinal();
                int tempAgeGroupOrdinal = ageGroupDataRow.getAgeGroup().ordinal();

                if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > mAgeGroupList.get(i - 1).ordinal())) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    mAgeGroupList.add(i, ageGroupDataRow.getAgeGroup());
                    break;

                } else if (mAgeGroupList.size() == i + 1) {

                    // If end of list has been reached, add row
                    mAgeGroupList.add(ageGroupDataRow.getAgeGroup());
                    break;

                }
            }
        }

        mAgeGroupDataRows.remove(rowIndex);
    }

    /**
     * Set population data navigator
     * @param baseAgeGroupNavigator
     */
    public void setBaseAgeGroupNavigator(BaseAgeGroupNavigator baseAgeGroupNavigator) {
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
    }

    /**
     * Retrieves list of age group
     * @return
     */
    public List<AgeGroupDataRow.AgeGroup> getAgeGroupList() {
        return mAgeGroupList;
    }

    /**
     * Retrieves number of data rows
     * @return
     */
    public int getDataRowsCount() {
        return mAgeGroupDataRows.size();
    }

    /**
     * Called when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        mBaseAgeGroupNavigator.onAddButtonPressed();
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {

    }
}
