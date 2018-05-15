package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnum;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgeGroupViewModel extends NewDncaGenInfoBaseViewModel {

    protected BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    protected List<AgeGroupDataRow> mAgeGroupDataRows = new ArrayList<>();

    public final ObservableArrayList<GenericEnum> ageGroupList = new ObservableArrayList<>();
    public final ObservableInt spinnerValue = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    protected BaseAgeGroupViewModel(Context context,
                                    NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager,
                                    Class<? extends Enum> enumClass) {

        super(context, newDncaGenInfoRepositoryManager);

        if (enumClass == AgeGroupDataRow.AgeGroup.class) {
            ageGroupList.addAll(AgeGroupDataRow.AgeGroup.asList());

        } else if (enumClass == AgeGroupDataRow.InfraType.class) {
            ageGroupList.addAll(AgeGroupDataRow.InfraType.asList());
        }
    }

    /**
     * Updates the age group list
     */
    protected void updateAgeGroupList() {

        // Remove items from age group list if age group is already in use
        for(AgeGroupDataRow row : mAgeGroupDataRows) {
            for (GenericEnum ageGroup : ageGroupList) {
                if (ageGroup.getOrdinal() == row.getAgeGroup().getOrdinal()) {
                    ageGroupList.remove(ageGroup);
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
                int currAgeGroupOrdinal = row.getAgeGroup().getOrdinal();
                int tempAgeGroupOrdinal = ageGroupDataRow.getAgeGroup().getOrdinal();

                if (currAgeGroupOrdinal == tempAgeGroupOrdinal) {

                    // If age group already exists, update its values
                    mAgeGroupDataRows.set(i, ageGroupDataRow);
                    break;

                } else if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > mAgeGroupDataRows.get(i - 1).getAgeGroup().getOrdinal())) {

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
        for(GenericEnum ageGroup : ageGroupList) {
            if (ageGroup.getOrdinal() == ageGroupDataRow.getAgeGroup().getOrdinal()) {
                ageGroupList.remove(ageGroup);
                return;
            }
        }

    }

    /**
     * Deletes age group data row
     * @param rowIndex
     */
    protected void deleteAgeGroupDataRow(int rowIndex) {

        AgeGroupDataRow ageGroupDataRow = mAgeGroupDataRows.get(rowIndex);

        // If list is empty, add new row right away
        if (ageGroupList.size() == 0) {
            ageGroupList.add(ageGroupDataRow.getAgeGroup());

        } else {

            // Else, select correct position
            for (int i = 0; i < ageGroupList.size(); i++) {

                int currAgeGroupOrdinal = ageGroupList.get(i).getOrdinal();
                int tempAgeGroupOrdinal = ageGroupDataRow.getAgeGroup().getOrdinal();

                if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > ageGroupList.get(i - 1).getOrdinal())) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    ageGroupList.add(i, ageGroupDataRow.getAgeGroup());
                    break;

                } else if (ageGroupList.size() == i + 1) {

                    // If end of list has been reached, add row
                    ageGroupList.add(ageGroupDataRow.getAgeGroup());
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
