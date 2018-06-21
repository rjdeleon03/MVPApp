package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.Evacuation.EvacuationPopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.EvacuationPopulationRepositoryManager;

public class EvacuationPopulationDialogViewModel extends DialogViewModel {

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
     * @param context
     * @param evacuationPopulationRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public EvacuationPopulationDialogViewModel(Context context,
                                               EvacuationPopulationRepositoryManager evacuationPopulationRepositoryManager,
                                               int ageGroupIndex,
                                               boolean isNewRow) {
        super(context);
        mEvacuationPopulationRepositoryManager = evacuationPopulationRepositoryManager;

        EvacuationPopulationDataRow evacuationPopulationDataRow;
        if (isNewRow) {
            evacuationPopulationDataRow = new EvacuationPopulationDataRow(mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataAgeGroup(ageGroupIndex));
        } else {
            evacuationPopulationDataRow = mEvacuationPopulationRepositoryManager.getEvacuationPopulationDataRow(ageGroupIndex);
        }
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
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        EvacuationPopulationDataRow evacuationPopulationDataRow = new EvacuationPopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(2)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(3)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(4)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(5)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(6)).value1.get());

        mEvacuationPopulationRepositoryManager.addEvacuationPopulationDataRow(evacuationPopulationDataRow);
        super.navigateOnOkButtonPressed();
    }
}
