package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Dialog;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class HouseDamageDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<ShelterHouseDamageDataRow, GenericEnumDataRow.HouseType> mHouseDamageRepositoryManager;

    private String[] mQuestions = {
            "Number of Houses",
            "Owned Houses",
            "Rented Houses",
            "Shared Houses",
            "Owned Land",
            "Rented Land",
            "Tenanted Land",
            "Informal Settlers",
            "Partially-Damaged Houses",
            "Totally-Damaged Houses",
            "All Damaged Houses"
    };

    /**
     * Constructor
     * @param houseDamageRepositoryManager
     * @param houseTypeIndex
     * @param isNewRow
     */
    public HouseDamageDialogViewModel(BaseEnumRepositoryManager<ShelterHouseDamageDataRow, GenericEnumDataRow.HouseType> houseDamageRepositoryManager,
                                      int houseTypeIndex,
                                      boolean isNewRow) {
        super();
        mHouseDamageRepositoryManager = houseDamageRepositoryManager;

        ShelterHouseDamageDataRow houseDamageDataRow;
        if (isNewRow) {
            houseDamageDataRow = new ShelterHouseDamageDataRow(mHouseDamageRepositoryManager.getEnumType(houseTypeIndex));
        } else {
            houseDamageDataRow = mHouseDamageRepositoryManager.getRow(houseTypeIndex);
        }

        type.set(houseDamageDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[0], houseDamageDataRow.getHouseCount())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[1], houseDamageDataRow.getOwnedHouse())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[2], houseDamageDataRow.getRentedHouse())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[3], houseDamageDataRow.getSharedHouse())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[4], houseDamageDataRow.getOwnedLand())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[5], houseDamageDataRow.getRentedLand())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[6], houseDamageDataRow.getTenantLand())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[7], houseDamageDataRow.getInformalSettlers())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[8], houseDamageDataRow.getPartiallyDamaged())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[9], houseDamageDataRow.getTotallyDamaged())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(new DialogItemModelSingleNumber(mQuestions[10], houseDamageDataRow.getAllDamaged())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
       ShelterHouseDamageDataRow houseDamageDataRow = new ShelterHouseDamageDataRow(
               (GenericEnumDataRow.HouseType) type.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(2)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(3)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(4)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(5)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(6)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(7)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(8)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(9)).value1.get(),
               ((DialogItemViewModelSingleNumber) mItemViewModels.get(10)).value1.get());

        mHouseDamageRepositoryManager.addRow(houseDamageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
