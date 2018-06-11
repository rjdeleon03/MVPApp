package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsRepositoryManager;

public class ShelterNeedsRowViewModel extends BaseEnumRowViewModel {

    private ShelterNeedsRepositoryManager mShelterNeedsRepositoryManager;

    public final ObservableField<String> items = new ObservableField<>("");
    public final ObservableInt familyCount = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param shelterNeedsRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public ShelterNeedsRowViewModel(Context context,
                                    ShelterNeedsRepositoryManager shelterNeedsRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator,
                                    int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mShelterNeedsRepositoryManager = shelterNeedsRepositoryManager;

        ShelterNeedsDataRow shelterNeedsDataRow = mShelterNeedsRepositoryManager.getShelterNeedsDataRow(rowIndex);
        type.set(shelterNeedsDataRow.getType());
        items.set(shelterNeedsDataRow.getItems());
        familyCount.set(shelterNeedsDataRow.getFamilyCount());
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mShelterNeedsRepositoryManager.deleteShelterNeedsDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
