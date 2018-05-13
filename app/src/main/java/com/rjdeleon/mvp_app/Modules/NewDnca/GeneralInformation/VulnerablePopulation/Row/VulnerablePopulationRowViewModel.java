package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Row.BaseAgeGroupRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public class VulnerablePopulationRowViewModel extends BaseAgeGroupRowViewModel {

    private VulnerablePopulationRepositoryManager mVulnerablePopulationRepositoryManager;

    public final ObservableInt pregnant = new ObservableInt(0);
    public final ObservableInt lactating = new ObservableInt(0);
    public final ObservableInt lgbt = new ObservableInt(0);
    public final ObservableInt femaleHeaded = new ObservableInt(0);
    public final ObservableInt childHeadedMale = new ObservableInt(0);
    public final ObservableInt childHeadedFemale = new ObservableInt(0);
    public final ObservableInt indigenousMale = new ObservableInt(0);
    public final ObservableInt indigenousFemale = new ObservableInt(0);
    public final ObservableInt disabledMale = new ObservableInt(0);
    public final ObservableInt disabledFemale = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");
    public final ObservableBoolean shouldShowOtherFields = new ObservableBoolean(true);
    public final ObservableBoolean shouldShowRemarks = new ObservableBoolean(true);

    /**
     * Constructor
     * @param context
     * @param vulnerablePopulationRepositoryManager
     * @param baseAgeGroupNavigator
     * @param rowIndex
     */
    public VulnerablePopulationRowViewModel(Context context,
                                            VulnerablePopulationRepositoryManager vulnerablePopulationRepositoryManager,
                                            BaseAgeGroupNavigator baseAgeGroupNavigator,
                                            int rowIndex) {

        super(context, baseAgeGroupNavigator, rowIndex);
        mVulnerablePopulationRepositoryManager = vulnerablePopulationRepositoryManager;

        VulnerablePopulationDataRow vulnerablePopulationDataRow = mVulnerablePopulationRepositoryManager.getVulnerablePopulationRow(mRowIndex);
        ageGroup.set(vulnerablePopulationDataRow.getAgeGroup());
        pregnant.set(vulnerablePopulationDataRow.getPregnant());
        lactating.set(vulnerablePopulationDataRow.getLactating());
        lgbt.set(vulnerablePopulationDataRow.getLgbt());
        femaleHeaded.set(vulnerablePopulationDataRow.getFemaleHeadedHouseholds());
        childHeadedMale.set(vulnerablePopulationDataRow.getChildHeadedHouseholds().male);
        childHeadedFemale.set(vulnerablePopulationDataRow.getChildHeadedHouseholds().female);
        indigenousMale.set(vulnerablePopulationDataRow.getIndigenous().male);
        indigenousFemale.set(vulnerablePopulationDataRow.getIndigenous().female);
        disabledMale.set(vulnerablePopulationDataRow.getDisabled().male);
        disabledFemale.set(vulnerablePopulationDataRow.getDisabled().female);
        remarks.set(vulnerablePopulationDataRow.getRemarks());

        // Set visibility of fields such as pregnant, lactating, and lgbt
        shouldShowOtherFields.set(ageGroup.get().ordinal() >= AgeGroupDataRow.AgeGroup.AGE_10_12.ordinal());
        shouldShowRemarks.set(remarks.get().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mVulnerablePopulationRepositoryManager.deleteVulnerablePopulationRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
