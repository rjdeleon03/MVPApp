package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public class VulnerablePopulationRowViewModel extends BaseEnumRowViewModel {

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
    public final ObservableBoolean shouldShowOtherFields = new ObservableBoolean(false);

    /**
     * Constructor
     * @param context
     * @param vulnerablePopulationRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public VulnerablePopulationRowViewModel(Context context,
                                            VulnerablePopulationRepositoryManager vulnerablePopulationRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {

        super(context, baseEnumNavigator, rowIndex);
        mVulnerablePopulationRepositoryManager = vulnerablePopulationRepositoryManager;

        VulnerablePopulationDataRow vulnerablePopulationDataRow = mVulnerablePopulationRepositoryManager.getVulnerablePopulationRow(mRowIndex);
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

        // Set visibility of fields such as pregnant, lactating, and lgbt
        shouldShowOtherFields.set(type.get().getOrdinal() >= GenericEnumDataRow.AgeGroup.AGE_10_12.getOrdinal());
        shouldShowRemarks.set(remarks.get().trim().length() > 0);
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