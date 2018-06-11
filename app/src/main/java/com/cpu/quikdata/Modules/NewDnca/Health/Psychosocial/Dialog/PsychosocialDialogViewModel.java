package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.PsychosocialRepositoryManager;

public class PsychosocialDialogViewModel extends BaseEnumDialogViewModel {

    private PsychosocialRepositoryManager mPsychosocialRepositoryManager;

    public final ObservableField<String> manifestations = new ObservableField<>("");
    public final ObservableInt casesMale = new ObservableInt(0);
    public final ObservableInt casesFemale = new ObservableInt(0);
    public final ObservableField<String> needs = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param psychosocialRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public PsychosocialDialogViewModel(Context context,
                                       PsychosocialRepositoryManager psychosocialRepositoryManager,
                                       int ageGroupIndex,
                                       boolean isNewRow) {
        super(context);
        mPsychosocialRepositoryManager = psychosocialRepositoryManager;

        if (isNewRow) {
            type.set(mPsychosocialRepositoryManager.getPsychosocialDataAgeGroup(ageGroupIndex));
        } else {
            PsychosocialDataRow psychosocialDataRow = mPsychosocialRepositoryManager.getPsychosocialDataRow(ageGroupIndex);
            type.set(psychosocialDataRow.getType());
            manifestations.set(psychosocialDataRow.getManifestations());
            casesMale.set(psychosocialDataRow.getCases().male);
            casesFemale.set(psychosocialDataRow.getCases().female);
            needs.set(psychosocialDataRow.getNeeds());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        PsychosocialDataRow psychosocialDataRow = new PsychosocialDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                manifestations.get(),
                new GenderTuple(casesMale.get(), casesFemale.get()),
                needs.get());

        mPsychosocialRepositoryManager.addPsychosocialDataRow(psychosocialDataRow);
        super.navigateOnOkButtonPressed();
    }
}