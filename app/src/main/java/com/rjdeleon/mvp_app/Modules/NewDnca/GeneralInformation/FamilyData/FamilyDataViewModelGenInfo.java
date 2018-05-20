package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public class FamilyDataViewModelGenInfo extends GenInfoBaseViewModel {

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
    public FamilyDataViewModelGenInfo(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
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
    public void navigateOnSaveButtonPressed() {
        FamilyData familyData = new FamilyData();
        familyData.setTotalFamilies(totalFamilies.get());
        familyData.setAffectedFamilies(affectedFamilies.get());
        familyData.setDisplacedFamilies(displacedFamilies.get());
        familyData.setTotalHouseholds(totalHouseholds.get());
        familyData.setAffectedHouseholds(affectedHouseholds.get());
        familyData.setDisplacedHouseholds(displacedHouseholds.get());
        mGenInfoRepositoryManager.saveFamilyData(familyData);
    }
}
