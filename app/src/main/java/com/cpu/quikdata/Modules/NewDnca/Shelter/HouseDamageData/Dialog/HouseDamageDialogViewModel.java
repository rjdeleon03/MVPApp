package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageRepositoryManager;

public class HouseDamageDialogViewModel extends DialogViewModel {

    private HouseDamageRepositoryManager mHouseDamageRepositoryManager;

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
     * @param context
     * @param houseDamageRepositoryManager
     * @param houseTypeIndex
     * @param isNewRow
     */
    public HouseDamageDialogViewModel(Context context,
                                      HouseDamageRepositoryManager houseDamageRepositoryManager,
                                      int houseTypeIndex,
                                      boolean isNewRow) {
        super(context);
        mHouseDamageRepositoryManager = houseDamageRepositoryManager;

        ShelterHouseDamageDataRow houseDamageDataRow;
        if (isNewRow) {
            houseDamageDataRow = new ShelterHouseDamageDataRow(mHouseDamageRepositoryManager.getHouseDamageDataHouseType(houseTypeIndex));
        } else {
            houseDamageDataRow = mHouseDamageRepositoryManager.getHouseDamageDataRow(houseTypeIndex);
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

        mHouseDamageRepositoryManager.addHouseDamageDataRow(houseDamageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
