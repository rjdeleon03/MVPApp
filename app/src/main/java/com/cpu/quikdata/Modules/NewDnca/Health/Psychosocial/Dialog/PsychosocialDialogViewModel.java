package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Dialog;

import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;

public class PsychosocialDialogViewModel extends DialogViewModel {

    private BaseEnumRepositoryManager<PsychosocialDataRow, GenericEnumDataRow.AgeGroup> mPsychosocialRepositoryManager;

    private String[] mQuestions = {
            "Manifestations of Mental Stress or Trauma",
            "Cases",
            "Needs"
    };

    private String[] mComments = {
            "(Blank stare, nightmares, sleep disorder, violent tendencies, etc.)",
            "(Counselling, referrals, etc.)"
    };

    /**
     * Constructor
     * @param psychosocialRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public PsychosocialDialogViewModel(BaseEnumRepositoryManager<PsychosocialDataRow, GenericEnumDataRow.AgeGroup> psychosocialRepositoryManager,
                                       int ageGroupIndex,
                                       boolean isNewRow) {
        super();
        mPsychosocialRepositoryManager = psychosocialRepositoryManager;

        PsychosocialDataRow psychosocialDataRow;
        if (isNewRow) {
            psychosocialDataRow = new PsychosocialDataRow(mPsychosocialRepositoryManager.getEnumType(ageGroupIndex));
        } else {
            psychosocialDataRow = mPsychosocialRepositoryManager.getRow(ageGroupIndex);
        }

        type.set(psychosocialDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[0], mComments[0], psychosocialDataRow.getManifestations())));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[1], psychosocialDataRow.getCases().male, psychosocialDataRow.getCases().female)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[2], mComments[1], psychosocialDataRow.getNeeds())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {

        DialogItemViewModelGenderTuple cases = (DialogItemViewModelGenderTuple) mItemViewModels.get(1);

        PsychosocialDataRow psychosocialDataRow = new PsychosocialDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(0)).value1.get(),
                new GenderTuple(cases.value1.get(), cases.value2.get()),
                ((DialogItemViewModelRemarks) mItemViewModels.get(2)).value1.get());

        mPsychosocialRepositoryManager.addRow(psychosocialDataRow);
        super.navigateOnOkButtonPressed();
    }
}