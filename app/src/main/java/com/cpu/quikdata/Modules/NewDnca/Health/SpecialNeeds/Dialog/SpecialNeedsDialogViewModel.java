package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.SpecialNeedsRepositoryManager;

public class SpecialNeedsDialogViewModel extends BaseEnumDialogViewModel {

    private SpecialNeedsRepositoryManager mSpecialNeedsRepositoryManager;

    public final ObservableInt count = new ObservableInt(0);
    public final ObservableField<String> needs = new ObservableField<>("");


    /**
     * Constructor
     * @param context
     * @param specialNeedsRepositoryManager
     * @param specialNeedsIndex
     * @param isNewRow
     */
    public SpecialNeedsDialogViewModel(Context context,
                                       SpecialNeedsRepositoryManager specialNeedsRepositoryManager,
                                       int specialNeedsIndex,
                                       boolean isNewRow) {
        super(context);
        mSpecialNeedsRepositoryManager = specialNeedsRepositoryManager;

        if (isNewRow) {
            type.set(mSpecialNeedsRepositoryManager.getSpecialNeedsDataType(specialNeedsIndex));
        } else {
            SpecialNeedsDataRow specialNeedsDataRow = mSpecialNeedsRepositoryManager.getSpecialNeedsDataRow(specialNeedsIndex);
            type.set(specialNeedsDataRow.getType());
            count.set(specialNeedsDataRow.getCount());
            needs.set(specialNeedsDataRow.getNeeds());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        SpecialNeedsDataRow specialNeedsDataRow = new SpecialNeedsDataRow(
                (GenericEnumDataRow.SpecialNeedsType) type.get(),
                count.get(),
                needs.get());

        mSpecialNeedsRepositoryManager.addSpecialNeedsDataRow(specialNeedsDataRow);
        super.navigateOnOkButtonPressed();
    }
}
