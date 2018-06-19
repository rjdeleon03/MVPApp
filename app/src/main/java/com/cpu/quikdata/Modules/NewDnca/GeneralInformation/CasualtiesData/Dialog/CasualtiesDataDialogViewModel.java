package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.CasualtiesDataRepositoryManager;

public class CasualtiesDataDialogViewModel extends DialogViewModel {

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
     */
    public CasualtiesDataDialogViewModel(Context context,
                                         CasualtiesDataRepositoryManager casualtiesDataRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super(context);
        mCasualtiesDataRepositoryManager = casualtiesDataRepositoryManager;

        CasualtiesDataRow casualtiesDataRow;
        if (isNewRow) {
            casualtiesDataRow = new CasualtiesDataRow(mCasualtiesDataRepositoryManager.getCasualtiesDataAgeGroup(ageGroupIndex));
        } else {
            casualtiesDataRow = mCasualtiesDataRepositoryManager.getCasualtiesDataRow(ageGroupIndex);
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
        mCasualtiesDataRepositoryManager.addCasualtiesDataRow(casualtiesDataRow);
        super.navigateOnOkButtonPressed();
    }
}
