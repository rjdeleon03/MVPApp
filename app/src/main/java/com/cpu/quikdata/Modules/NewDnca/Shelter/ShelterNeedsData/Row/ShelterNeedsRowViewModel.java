package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row;

import android.content.Context;

import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.ShelterNeedsRepositoryManager;

public class ShelterNeedsRowViewModel extends RowViewModel {

    private ShelterNeedsRepositoryManager mShelterNeedsRepositoryManager;

    private String[] mQuestions = {
            "Identify Specific Items",
            "Number of Families in Need"
    };

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

        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], shelterNeedsDataRow.getItems())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], shelterNeedsDataRow.getFamilyCount(), true)));
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
