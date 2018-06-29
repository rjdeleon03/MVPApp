package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Row;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationRepositoryManager;

public class EvacuationPopulationRowViewModel extends RowViewModel {

    private EvacuationPopulationRepositoryManager mEvacuationPopulationRepositoryManager;

    private String[] mQuestions = {
            "Male",
            "Female",
            "LGBT",
            "Pregnant Women",
            "Lactating Mothers",
            "Persons with Disabilities",
            "Sick"
    };

    /**
     * Constructor
     * @param evacuationPopulationRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public EvacuationPopulationRowViewModel(EvacuationPopulationRepositoryManager evacuationPopulationRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {
        super(baseEnumNavigator, rowIndex);
        mEvacuationPopulationRepositoryManager = evacuationPopulationRepositoryManager;

        EvacuationPopulationDataRow evacuationPopulationDataRow = mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataRow(mRowIndex);
        type.set(evacuationPopulationDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[0], evacuationPopulationDataRow.getMale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], evacuationPopulationDataRow.getFemale())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[2], evacuationPopulationDataRow.getLgbt())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[3], evacuationPopulationDataRow.getPregnant())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[4], evacuationPopulationDataRow.getLactating())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[5], evacuationPopulationDataRow.getDisabled())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[6], evacuationPopulationDataRow.getSick())));
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mEvacuationPopulationRepositoryManager.deleteEvacuationPopulationDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
