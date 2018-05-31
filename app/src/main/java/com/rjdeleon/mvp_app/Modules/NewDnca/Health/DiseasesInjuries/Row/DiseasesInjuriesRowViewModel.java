package com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Row;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Health.DiseasesInjuriesDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesRepositoryManager;

public class DiseasesInjuriesRowViewModel extends BaseEnumRowViewModel {

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
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public DiseasesInjuriesRowViewModel(Context context,
                                        DiseasesInjuriesRepositoryManager diseasesInjuriesRepositoryManager,
                                        BaseEnumNavigator baseEnumNavigator,
                                        int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mDiseasesInjuriesRepositoryManager = diseasesInjuriesRepositoryManager;

        DiseasesInjuriesDataRow diseasesInjuriesDataRow = mDiseasesInjuriesRepositoryManager.getDiseasesInjuriesDataRow(rowIndex);
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

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mDiseasesInjuriesRepositoryManager.deleteDiseasesInjuriesDataRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
