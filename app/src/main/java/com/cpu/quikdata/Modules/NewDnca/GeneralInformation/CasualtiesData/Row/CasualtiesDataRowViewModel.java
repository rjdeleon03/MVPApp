package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataRepositoryManager;

public class CasualtiesDataRowViewModel extends RowViewModel {

    private CasualtiesDataRepositoryManager mCasualtiesDataRepositoryManager;

    private String[] mQuestions = {
            "Dead",
            "Missing",
            "Injured"
    };

    /**
     * Constructor
     *
     * @param context
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public CasualtiesDataRowViewModel(Context context,
                                      CasualtiesDataRepositoryManager casualtiesDataRepositoryManager,
                                      BaseEnumNavigator baseEnumNavigator,
                                      int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        CasualtiesDataRow casualtiesDataRow = mCasualtiesDataRepositoryManager.getCasualtiesDataRow(mRowIndex);
        type.set(casualtiesDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[0], casualtiesDataRow.getDead().male, casualtiesDataRow.getDead().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[1], casualtiesDataRow.getMissing().male, casualtiesDataRow.getMissing().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[2], casualtiesDataRow.getInjured().male, casualtiesDataRow.getInjured().female)));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mCasualtiesDataRepositoryManager.deleteCasualtiesDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
