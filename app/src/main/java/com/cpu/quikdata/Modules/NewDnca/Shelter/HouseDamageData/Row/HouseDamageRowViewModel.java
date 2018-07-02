package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Row;

import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class HouseDamageRowViewModel extends RowViewModel {

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
     * Generates new instance
     * @return
     */
    public static HouseDamageRowViewModel newInstance() {
        return new HouseDamageRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public HouseDamageRowViewModel() {
        super();
    }

    /**
     * Sets the relevant variables to obtain data row
     * @param baseEnumNavigator
     * @param repositoryManager
     * @param rowIndex
     */
    @Override
    public void setData(BaseEnumNavigator baseEnumNavigator, BaseEnumRepositoryManager repositoryManager, int rowIndex) {
        super.setData(baseEnumNavigator, repositoryManager, rowIndex);

        ShelterHouseDamageDataRow houseDamageDataRow = (ShelterHouseDamageDataRow) mRepositoryManager.getRow(mRowIndex);
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
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mRepositoryManager.deleteRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
