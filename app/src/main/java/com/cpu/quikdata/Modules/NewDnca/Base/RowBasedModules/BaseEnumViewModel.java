package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public abstract class BaseEnumViewModel extends NewDncaBaseViewModel {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected List<GenericEnumDataRow> mGenericEnumDataRows = new ArrayList<>();

    public final ObservableBoolean shouldShowSpinner = new ObservableBoolean(false);
    public final ObservableArrayList<GenericEnum> ageGroupList = new ObservableArrayList<>();
    public final ObservableInt spinnerValue = new ObservableInt(0);

    /**
     * Constructor
     * @param enumClass
     */
    protected BaseEnumViewModel(@Nullable Class<? extends Enum> enumClass) {

        super();
        if (enumClass == null || enumClass == GenericEnumDataRow.Assistance.class) {
            return;
        }

        shouldShowSpinner.set(true);
        if (enumClass == GenericEnumDataRow.AgeGroup.class) {
            ageGroupList.addAll(GenericEnumDataRow.AgeGroup.asList());

        } else if (enumClass == GenericEnumDataRow.InfraType.class) {
            ageGroupList.addAll(GenericEnumDataRow.InfraType.asList());

        } else if (enumClass == GenericEnumDataRow.HouseType.class) {
            ageGroupList.addAll(GenericEnumDataRow.HouseType.asList());

        } else if (enumClass == GenericEnumDataRow.NeedsType.class) {
            ageGroupList.addAll(GenericEnumDataRow.NeedsType.asList());

        } else if (enumClass == GenericEnumDataRow.IncomeSourceType.class) {
            ageGroupList.addAll(GenericEnumDataRow.IncomeSourceType.asList());

        } else if (enumClass == GenericEnumDataRow.LivelihoodsType.class) {
            ageGroupList.addAll(GenericEnumDataRow.LivelihoodsType.asList());

        } else if (enumClass == GenericEnumDataRow.SpecialNeedsType.class) {
            ageGroupList.addAll(GenericEnumDataRow.SpecialNeedsType.asList());

        }
    }

    /**
     * Updates the age group list
     */
    protected void updateAgeGroupList() {

        // Remove items from age group list if age group is already in use
        for(GenericEnumDataRow row : mGenericEnumDataRows) {
            for (GenericEnum ageGroup : ageGroupList) {
                if (ageGroup.getOrdinal() == row.getType().getOrdinal()) {
                    ageGroupList.remove(ageGroup);
                    break;
                }
            }
        }
    }

    /**
     * Adds age group data row
     * @param genericEnumDataRow
     */
    protected void addAgeGroupDataRow(GenericEnumDataRow genericEnumDataRow) {

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

    }

    /**
     * Deletes age group data row
     * @param rowIndex
     */
    protected void deleteAgeGroupDataRow(int rowIndex) {

        GenericEnumDataRow genericEnumDataRow = mGenericEnumDataRows.get(rowIndex);

        // If list is empty, add new row right away
        if (ageGroupList.size() == 0) {
            ageGroupList.add(genericEnumDataRow.getType());

        } else {

            // Else, select correct position
            for (int i = 0; i < ageGroupList.size(); i++) {

                int currAgeGroupOrdinal = ageGroupList.get(i).getOrdinal();
                int tempAgeGroupOrdinal = genericEnumDataRow.getType().getOrdinal();

                if (currAgeGroupOrdinal > tempAgeGroupOrdinal &&
                        (i == 0 || tempAgeGroupOrdinal > ageGroupList.get(i - 1).getOrdinal())) {

                    // If row must be inserted somewhere in the middle, find its correct position
                    ageGroupList.add(i, genericEnumDataRow.getType());
                    break;

                } else if (ageGroupList.size() == i + 1) {

                    // If end of list has been reached, add row
                    ageGroupList.add(genericEnumDataRow.getType());
                    break;

                }
            }
        }

        mGenericEnumDataRows.remove(rowIndex);
    }

    /**
     * Set population data navigator
     * @param baseEnumNavigator
     */
    public void setBaseAgeGroupNavigator(BaseEnumNavigator baseEnumNavigator) {
        mBaseEnumNavigator = baseEnumNavigator;
    }

    /**
     * Retrieves number of data rows
     * @return
     */
    public int getDataRowsCount() {
        return mGenericEnumDataRows.size();
    }

    /**
     * Called when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        mBaseEnumNavigator.onAddButtonPressed();
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {

    }

    /**
     * Gets the number of data rows
     * @return
     */
    public int getRowsCount() {
        return mGenericEnumDataRows.size();
    }
}
