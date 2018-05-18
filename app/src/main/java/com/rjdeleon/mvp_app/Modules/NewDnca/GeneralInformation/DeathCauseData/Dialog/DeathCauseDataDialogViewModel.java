package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseRepositoryManager;

public class DeathCauseDataDialogViewModel extends BaseAgeGroupDialogViewModel {

    private DeathCauseRepositoryManager mDeathCauseRepositoryManager;

    public final ObservableInt measlesMale = new ObservableInt(0);
    public final ObservableInt measlesFemale = new ObservableInt(0);
    public final ObservableInt diarrheaMale = new ObservableInt(0);
    public final ObservableInt diarrheaFemale = new ObservableInt(0);
    public final ObservableInt pneumoniaMale = new ObservableInt(0);
    public final ObservableInt pneumoniaFemale = new ObservableInt(0);
    public final ObservableInt dengueMale = new ObservableInt(0);
    public final ObservableInt dengueFemale = new ObservableInt(0);
    public final ObservableInt drowningMale = new ObservableInt(0);
    public final ObservableInt drowningFemale = new ObservableInt(0);
    public final ObservableInt heartAttackMale = new ObservableInt(0);
    public final ObservableInt heartAttackFemale = new ObservableInt(0);
    public final ObservableInt electrocutionMale = new ObservableInt(0);
    public final ObservableInt electrocutionFemale = new ObservableInt(0);
    public final ObservableInt collapsedMale = new ObservableInt(0);
    public final ObservableInt collapsedFemale = new ObservableInt(0);
    public final ObservableInt othersMale = new ObservableInt(0);
    public final ObservableInt othersFemale = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param deathCauseRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public DeathCauseDataDialogViewModel(Context context,
                                         DeathCauseRepositoryManager deathCauseRepositoryManager,
                                         int ageGroupIndex,
                                         boolean isNewRow) {
        super(context);
        mDeathCauseRepositoryManager = deathCauseRepositoryManager;

        if (isNewRow) {
            ageGroup.set(mDeathCauseRepositoryManager.getPopulationDataAgeGroup(ageGroupIndex));
        } else {
            DeathCauseDataRow deathCauseDataRow = mDeathCauseRepositoryManager.getDeathCauseDataRow(ageGroupIndex);
            ageGroup.set(deathCauseDataRow.getType());
            measlesMale.set(deathCauseDataRow.getMeasles().male);
            measlesFemale.set(deathCauseDataRow.getMeasles().female);
            diarrheaMale.set(deathCauseDataRow.getDiarrhea().male);
            diarrheaFemale.set(deathCauseDataRow.getDiarrhea().female);
            pneumoniaMale.set(deathCauseDataRow.getPneumonia().male);
            pneumoniaFemale.set(deathCauseDataRow.getPneumonia().female);
            dengueMale.set(deathCauseDataRow.getDengue().male);
            dengueFemale.set(deathCauseDataRow.getDengue().female);
            drowningMale.set(deathCauseDataRow.getDrowning().male);
            drowningFemale.set(deathCauseDataRow.getDrowning().female);
            heartAttackMale.set(deathCauseDataRow.getHeartAttack().male);
            heartAttackFemale.set(deathCauseDataRow.getHeartAttack().female);
            electrocutionMale.set(deathCauseDataRow.getElectrocution().male);
            electrocutionFemale.set(deathCauseDataRow.getElectrocution().female);
            collapsedMale.set(deathCauseDataRow.getCollapsedBuilding().male);
            collapsedFemale.set(deathCauseDataRow.getCollapsedBuilding().female);
            othersMale.set(deathCauseDataRow.getOthers().male);
            othersFemale.set(deathCauseDataRow.getOthers().female);
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DeathCauseDataRow deathCauseDataRow = new DeathCauseDataRow(
                (GenericEnumDataRow.AgeGroup) ageGroup.get(),
                new GenderTuple(measlesMale.get(), measlesFemale.get()),
                new GenderTuple(diarrheaMale.get(), diarrheaFemale.get()),
                new GenderTuple(pneumoniaMale.get(), pneumoniaFemale.get()),
                new GenderTuple(dengueMale.get(), dengueFemale.get()),
                new GenderTuple(drowningMale.get(), drowningFemale.get()),
                new GenderTuple(heartAttackMale.get(), heartAttackFemale.get()),
                new GenderTuple(electrocutionMale.get(), electrocutionFemale.get()),
                new GenderTuple(collapsedMale.get(), collapsedFemale.get()),
                new GenderTuple(othersFemale.get(), othersFemale.get())
        );
        mDeathCauseRepositoryManager.addDeathCauseDataRow(deathCauseDataRow);
        super.navigateOnOkButtonPressed();
    }
}
