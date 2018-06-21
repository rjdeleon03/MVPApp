package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Row;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

public class PopulationDataRowViewModel extends RowViewModel implements DialogItemDataSource {

    private PopulationDataRepositoryManager mPopulationDataRepositoryManager;

    private String[] mQuestions = {
            "Total",
            "Affected",
            "Displaced"
    };

    /**
     * Constructor
     * @param context
     * @param populationDataRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public PopulationDataRowViewModel(Context context,
                                      PopulationDataRepositoryManager populationDataRepositoryManager,
                                      BaseEnumNavigator baseEnumNavigator,
                                      int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mPopulationDataRepositoryManager = populationDataRepositoryManager;

        PopulationDataRow populationDataRow = mPopulationDataRepositoryManager.getPopulationDataRow(rowIndex);
        type.set(populationDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], populationDataRow.getTotal().male, populationDataRow.getTotal().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], populationDataRow.getAffected().male, populationDataRow.getAffected().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], populationDataRow.getDisplaced().male, populationDataRow.getDisplaced().female)));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mPopulationDataRepositoryManager.deletePopulationDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
