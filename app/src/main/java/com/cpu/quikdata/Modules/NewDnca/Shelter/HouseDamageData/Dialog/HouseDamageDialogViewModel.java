package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterHouseDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageRepositoryManager;

public class HouseDamageDialogViewModel extends BaseEnumDialogViewModel {

    private HouseDamageRepositoryManager mHouseDamageRepositoryManager;

    public final ObservableInt houseCount = new ObservableInt(0);
    public final ObservableInt ownedHouse = new ObservableInt(0);
    public final ObservableInt rentedHouse = new ObservableInt(0);
    public final ObservableInt sharedHouse = new ObservableInt(0);
    public final ObservableInt ownedLand = new ObservableInt(0);
    public final ObservableInt rentedLand = new ObservableInt(0);
    public final ObservableInt tenantLand = new ObservableInt(0);
    public final ObservableInt informalSettlers = new ObservableInt(0);
    public final ObservableInt partiallyDamaged = new ObservableInt(0);
    public final ObservableInt totallyDamaged = new ObservableInt(0);
    public final ObservableInt allDamaged = new ObservableInt(0);

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

        if (isNewRow) {
            type.set(mHouseDamageRepositoryManager.getHouseDamageDataHouseType(houseTypeIndex));
        } else {
            ShelterHouseDamageDataRow houseDamageDataRow = mHouseDamageRepositoryManager.getHouseDamageDataRow(houseTypeIndex);
            type.set(houseDamageDataRow.getType());
            houseCount.set(houseDamageDataRow.getHouseCount());
            ownedHouse.set(houseDamageDataRow.getOwnedHouse());
            rentedHouse.set(houseDamageDataRow.getRentedHouse());
            sharedHouse.set(houseDamageDataRow.getSharedHouse());
            ownedLand.set(houseDamageDataRow.getOwnedLand());
            rentedLand.set(houseDamageDataRow.getRentedLand());
            tenantLand.set(houseDamageDataRow.getTenantLand());
            informalSettlers.set(houseDamageDataRow.getInformalSettlers());
            partiallyDamaged.set(houseDamageDataRow.getPartiallyDamaged());
            totallyDamaged.set(houseDamageDataRow.getTotallyDamaged());
            allDamaged.set(houseDamageDataRow.getAllDamaged());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
       ShelterHouseDamageDataRow houseDamageDataRow = new ShelterHouseDamageDataRow(
               (GenericEnumDataRow.HouseType) type.get(),
               houseCount.get(),
               ownedHouse.get(),
               rentedHouse.get(),
               sharedHouse.get(),
               ownedLand.get(),
               rentedLand.get(),
               tenantLand.get(),
               informalSettlers.get(),
               partiallyDamaged.get(),
               totallyDamaged.get(),
               allDamaged.get());

        mHouseDamageRepositoryManager.addHouseDamageDataRow(houseDamageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
