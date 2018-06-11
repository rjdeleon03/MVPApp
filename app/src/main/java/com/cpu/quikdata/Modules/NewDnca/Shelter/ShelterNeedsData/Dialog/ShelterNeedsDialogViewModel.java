package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsRepositoryManager;

public class ShelterNeedsDialogViewModel extends BaseEnumDialogViewModel {

    private ShelterNeedsRepositoryManager mShelterNeedsRepositoryManager;

    public final ObservableField<String> items = new ObservableField<>("");
    public final ObservableInt familyCount = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     */
    public ShelterNeedsDialogViewModel(Context context,
                                       ShelterNeedsRepositoryManager shelterNeedsRepositoryManager,
                                       int needsTypeIndex,
                                       boolean isNewRow) {
        super(context);
        mShelterNeedsRepositoryManager = shelterNeedsRepositoryManager;

        if (isNewRow) {
            type.set(mShelterNeedsRepositoryManager.getShelterNeedsDataType(needsTypeIndex));
        } else {
            ShelterNeedsDataRow shelterNeedsDataRow = mShelterNeedsRepositoryManager.getShelterNeedsDataRow(needsTypeIndex);
            type.set(shelterNeedsDataRow.getType());
            items.set(shelterNeedsDataRow.getItems());
            familyCount.set(shelterNeedsDataRow.getFamilyCount());
        }
    }


    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        ShelterNeedsDataRow shelterNeedsDataRow = new ShelterNeedsDataRow(
                (GenericEnumDataRow.NeedsType) type.get(),
                items.get(),
                familyCount.get());
        mShelterNeedsRepositoryManager.addShelterNeedsDataRow(shelterNeedsDataRow);
        super.navigateOnOkButtonPressed();
    }

}
