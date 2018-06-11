package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public class VulnerablePopulationDialogViewModel extends BaseEnumDialogViewModel {

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

    /**
     * Constructor
     * @param context
     * @param vulnerablePopulationRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public VulnerablePopulationDialogViewModel(Context context,
                                               VulnerablePopulationRepositoryManager vulnerablePopulationRepositoryManager,
                                               int ageGroupIndex,
                                               boolean isNewRow) {
        super(context);
        mVulnerablePopulationRepositoryManager = vulnerablePopulationRepositoryManager;

        if (isNewRow) {
            type.set(mVulnerablePopulationRepositoryManager.getVulnerablePopulationAgeGroup(ageGroupIndex));
        } else {
            VulnerablePopulationDataRow vulnerablePopulationDataRow = mVulnerablePopulationRepositoryManager.getVulnerablePopulationRow(ageGroupIndex);

            type.set(vulnerablePopulationDataRow.getType());
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
        }

        // Set visibility of fields such as pregnant, lactating, and lgbt
        shouldShowOtherFields.set(type.get().getOrdinal() >= GenericEnumDataRow.AgeGroup.AGE_10_12.getOrdinal());
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        VulnerablePopulationDataRow vulnerablePopulationDataRow = new VulnerablePopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                lactating.get(),
                pregnant.get(),
                lgbt.get(),
                femaleHeaded.get(),
                new GenderTuple(childHeadedMale.get(), childHeadedFemale.get()),
                new GenderTuple(indigenousMale.get(), indigenousFemale.get()),
                new GenderTuple(disabledMale.get(), disabledFemale.get()),
                remarks.get()
        );
        mVulnerablePopulationRepositoryManager.addVulnerablePopulationRow(vulnerablePopulationDataRow);
        super.navigateOnOkButtonPressed();
    }
}
