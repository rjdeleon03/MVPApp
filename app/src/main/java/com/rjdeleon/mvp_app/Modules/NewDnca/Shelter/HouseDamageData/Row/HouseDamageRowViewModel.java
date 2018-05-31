package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Shelter.ShelterHouseDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.HouseDamageRepositoryManager;

public class HouseDamageRowViewModel extends BaseEnumRowViewModel {

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public HouseDamageRowViewModel(Context context,
                                   HouseDamageRepositoryManager houseDamageRepositoryManager,
                                   BaseEnumNavigator baseEnumNavigator,
                                   int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mHouseDamageRepositoryManager = houseDamageRepositoryManager;

        ShelterHouseDamageDataRow houseDamageDataRow = mHouseDamageRepositoryManager.getHouseDamageDataRow(mRowIndex);
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

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mHouseDamageRepositoryManager.deleteHouseDamageDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
