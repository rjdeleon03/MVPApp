package com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Dialog;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.GenderTuple;
import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesRepositoryManager;

public class DiseasesInjuriesDialogViewModel extends BaseEnumDialogViewModel {

    private DiseasesInjuriesRepositoryManager mDiseasesInjuriesRepositoryManager;

    public final ObservableInt measlesMale = new ObservableInt(0);
    public final ObservableInt measlesFemale = new ObservableInt(0);
    public final ObservableInt diarrheaMale = new ObservableInt(0);
    public final ObservableInt diarrheaFemale = new ObservableInt(0);
    public final ObservableInt pneumoniaMale = new ObservableInt(0);
    public final ObservableInt pneumoniaFemale = new ObservableInt(0);
    public final ObservableInt dengueMale = new ObservableInt(0);
    public final ObservableInt dengueFemale = new ObservableInt(0);
    public final ObservableInt illOthersMale = new ObservableInt(0);
    public final ObservableInt illOthersFemale = new ObservableInt(0);
    public final ObservableInt checkUpMale = new ObservableInt(0);
    public final ObservableInt checkUpFemale = new ObservableInt(0);
    public final ObservableInt hospitalizationMale = new ObservableInt(0);
    public final ObservableInt hospitalizationFemale = new ObservableInt(0);
    public final ObservableInt medicinesMale = new ObservableInt(0);
    public final ObservableInt medicinesFemale = new ObservableInt(0);
    public final ObservableInt medOthersMale = new ObservableInt(0);
    public final ObservableInt medOthersFemale = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param diseasesInjuriesRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public DiseasesInjuriesDialogViewModel(Context context,
                                           DiseasesInjuriesRepositoryManager diseasesInjuriesRepositoryManager,
                                           int ageGroupIndex,
                                           boolean isNewRow) {
        super(context);
        mDiseasesInjuriesRepositoryManager = diseasesInjuriesRepositoryManager;

        if (isNewRow) {
            type.set(mDiseasesInjuriesRepositoryManager.getDiseasesInjuriesAgeGroup(ageGroupIndex));
        } else {

            DiseasesInjuriesDataRow diseasesInjuriesDataRow = mDiseasesInjuriesRepositoryManager.getDiseasesInjuriesDataRow(ageGroupIndex);
            type.set(diseasesInjuriesDataRow.getType());
            measlesMale.set(diseasesInjuriesDataRow.getMeasles().male);
            measlesFemale.set(diseasesInjuriesDataRow.getMeasles().female);
            diarrheaMale.set(diseasesInjuriesDataRow.getDiarrhea().male);
            diarrheaFemale.set(diseasesInjuriesDataRow.getDiarrhea().female);
            pneumoniaMale.set(diseasesInjuriesDataRow.getPneumonia().male);
            pneumoniaFemale.set(diseasesInjuriesDataRow.getPneumonia().female);
            dengueMale.set(diseasesInjuriesDataRow.getDengue().male);
            dengueFemale.set(diseasesInjuriesDataRow.getDengue().female);
            illOthersMale.set(diseasesInjuriesDataRow.getIllOthers().male);
            illOthersFemale.set(diseasesInjuriesDataRow.getIllOthers().female);
            checkUpMale.set(diseasesInjuriesDataRow.getCheckUp().male);
            checkUpFemale.set(diseasesInjuriesDataRow.getCheckUp().female);
            hospitalizationMale.set(diseasesInjuriesDataRow.getHospitalization().male);
            hospitalizationFemale.set(diseasesInjuriesDataRow.getHospitalization().female);
            medicinesMale.set(diseasesInjuriesDataRow.getMedicines().male);
            medicinesFemale.set(diseasesInjuriesDataRow.getMedicines().female);
            medOthersMale.set(diseasesInjuriesDataRow.getMedOthers().male);
            medOthersFemale.set(diseasesInjuriesDataRow.getMedOthers().female);
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DiseasesInjuriesDataRow diseasesInjuriesDataRow = new DiseasesInjuriesDataRow(
                type.get(),
                new GenderTuple(measlesMale.get(), measlesFemale.get()),
                new GenderTuple(diarrheaMale.get(), diarrheaFemale.get()),
                new GenderTuple(pneumoniaMale.get(), pneumoniaFemale.get()),
                new GenderTuple(dengueMale.get(), dengueFemale.get()),
                new GenderTuple(illOthersMale.get(), illOthersFemale.get()),
                new GenderTuple(checkUpMale.get(), checkUpFemale.get()),
                new GenderTuple(hospitalizationMale.get(), hospitalizationFemale.get()),
                new GenderTuple(medicinesMale.get(), medicinesFemale.get()),
                new GenderTuple(medOthersMale.get(), medOthersFemale.get()));
        mDiseasesInjuriesRepositoryManager.addDiseasesInjuriesDataRow(diseasesInjuriesDataRow);
        super.navigateOnOkButtonPressed();
    }
}
