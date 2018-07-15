package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class ShelterNeedsDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<ShelterNeedsDataRow, GenericEnumDataRow.NeedsType> mShelterNeedsRepositoryManager;

    private String[] mQuestions = {
            "Identify Specific Items",
            "Number of Families in Need"
    };

    /**
     * Constructor
     * @param shelterNeedsRepositoryManager
     * @param needsTypeIndex
     * @param isNewRow
     */
    public ShelterNeedsDialogViewModel(BaseEnumRepositoryManager<ShelterNeedsDataRow, GenericEnumDataRow.NeedsType> shelterNeedsRepositoryManager,
                                       int needsTypeIndex,
                                       boolean isNewRow) {
        super();
        mShelterNeedsRepositoryManager = shelterNeedsRepositoryManager;

        ShelterNeedsDataRow shelterNeedsDataRow;
        if (isNewRow) {
            shelterNeedsDataRow = new ShelterNeedsDataRow(mShelterNeedsRepositoryManager.getEnumType(needsTypeIndex));
        } else {
            shelterNeedsDataRow = mShelterNeedsRepositoryManager.getRow(needsTypeIndex);
        }

        type.set(shelterNeedsDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], shelterNeedsDataRow.getItems())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], shelterNeedsDataRow.getFamilyCount(), true)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        ShelterNeedsDataRow shelterNeedsDataRow = new ShelterNeedsDataRow(
                (GenericEnumDataRow.NeedsType) type.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get());

        mShelterNeedsRepositoryManager.addRow(shelterNeedsDataRow);
        super.navigateOnOkButtonPressed();
    }

}
