package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class CasualtiesDataDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<CasualtiesDataRow, GenericEnumDataRow.AgeGroup> mCasualtiesDataRepositoryManager;

    private String[] mQuestions = {
            "Dead",
            "Missing",
            "Injured"
    };

    /**
     * Constructor
     * @param casualtiesDataRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public CasualtiesDataDialogViewModel(BaseEnumRepositoryManager<CasualtiesDataRow, GenericEnumDataRow.AgeGroup> casualtiesDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super();
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        CasualtiesDataRow casualtiesDataRow;
        if (isNewRow) {
            casualtiesDataRow = new CasualtiesDataRow(mCasualtiesDataRepositoryManager.getEnumType(ageGroupIndex));
        } else {
            casualtiesDataRow = mCasualtiesDataRepositoryManager.getRow(ageGroupIndex);
        }

        type.set(casualtiesDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[0], casualtiesDataRow.getDead().male, casualtiesDataRow.getDead().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[1], casualtiesDataRow.getMissing().male, casualtiesDataRow.getMissing().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[2], casualtiesDataRow.getInjured().male, casualtiesDataRow.getInjured().female)));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DialogItemViewModelGenderTuple dead = (DialogItemViewModelGenderTuple) mItemViewModels.get(0);
        DialogItemViewModelGenderTuple missing = (DialogItemViewModelGenderTuple) mItemViewModels.get(1);
        DialogItemViewModelGenderTuple injured = (DialogItemViewModelGenderTuple) mItemViewModels.get(2);

        CasualtiesDataRow casualtiesDataRow = new CasualtiesDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                new GenderTuple(dead.value1.get(), dead.value2.get()),
                new GenderTuple(missing.value1.get(), missing.value2.get()),
                new GenderTuple(injured.value1.get(), injured.value2.get())
        );
        mCasualtiesDataRepositoryManager.addRow(casualtiesDataRow);
        super.navigateOnOkButtonPressed();
    }
}
