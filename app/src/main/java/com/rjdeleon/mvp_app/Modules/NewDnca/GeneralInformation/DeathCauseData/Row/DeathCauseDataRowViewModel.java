package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Row.BaseAgeGroupRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.DeathCauseRepositoryManager;

public class DeathCauseDataRowViewModel extends BaseAgeGroupRowViewModel {

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
     *
     * @param context
     * @param baseAgeGroupNavigator
     * @param rowIndex
     */
    public DeathCauseDataRowViewModel(Context context,
                                      DeathCauseRepositoryManager deathCauseRepositoryManager,
                                      BaseAgeGroupNavigator baseAgeGroupNavigator,
                                      int rowIndex) {

        super(context, baseAgeGroupNavigator, rowIndex);
        mDeathCauseRepositoryManager = deathCauseRepositoryManager;

        DeathCauseDataRow deathCauseDataRow = mDeathCauseRepositoryManager.getDeathCauseDataRow(mRowIndex);
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

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mDeathCauseRepositoryManager.deleteDeathCauseDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }

}
