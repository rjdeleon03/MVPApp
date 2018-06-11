package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsRepositoryManager;

public class SpecialNeedsRowViewModel extends BaseEnumRowViewModel {

    private SpecialNeedsRepositoryManager mSpecialNeedsRepositoryManager;

    public final ObservableInt count = new ObservableInt(0);
    public final ObservableField<String> needs = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param specialNeedsRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public SpecialNeedsRowViewModel(Context context,
                                    SpecialNeedsRepositoryManager specialNeedsRepositoryManager,
                                    BaseEnumNavigator baseEnumNavigator,
                                    int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mSpecialNeedsRepositoryManager = specialNeedsRepositoryManager;

        SpecialNeedsDataRow specialNeedsDataRow = mSpecialNeedsRepositoryManager.getSpecialNeedsDataRow(rowIndex);
        type.set(specialNeedsDataRow.getType());
        count.set(specialNeedsDataRow.getCount());
        needs.set(specialNeedsDataRow.getNeeds());
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mSpecialNeedsRepositoryManager.deleteSpecialNeedsDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
