package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.FamilyData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.cpu.quikdata.Models.GeneralInformation.FamilyData;
import com.cpu.quikdata.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public class FamilyDataViewModel extends GenInfoBaseViewModel implements NonEnumSaveableSection {

    public final ObservableInt totalFamilies = new ObservableInt(0);
    public final ObservableInt affectedFamilies = new ObservableInt(0);
    public final ObservableInt displacedFamilies = new ObservableInt(0);
    public final ObservableInt totalHouseholds = new ObservableInt(0);
    public final ObservableInt affectedHouseholds = new ObservableInt(0);
    public final ObservableInt displacedHouseholds = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param genInfoRepositoryManager
     */
    public FamilyDataViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context, genInfoRepositoryManager);

        FamilyData familyData = mGenInfoRepositoryManager.getFamilyData();
        totalFamilies.set(familyData.getTotalFamilies());
        affectedFamilies.set(familyData.getAffectedFamilies());
        displacedFamilies.set(familyData.getDisplacedFamilies());
        totalHouseholds.set(familyData.getTotalHouseholds());
        affectedHouseholds.set(familyData.getAffectedHouseholds());
        displacedHouseholds.set(familyData.getDisplacedHouseholds());
    }

    /**
     * Navigate when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        FamilyData familyData = new FamilyData(totalFamilies.get(),
                affectedFamilies.get(),
                displacedFamilies.get(),
                totalHouseholds.get(),
                affectedHouseholds.get(),
                displacedHouseholds.get());
        mGenInfoRepositoryManager.saveFamilyData(familyData);
    }
}
