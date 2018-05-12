package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.FamilyData;

import android.content.Context;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

public class FamilyDataViewModel extends NewDncaGenInfoBaseViewModel {

    public final ObservableInt totalFamilies = new ObservableInt(0);
    public final ObservableInt affectedFamilies = new ObservableInt(0);
    public final ObservableInt displacedFamilies = new ObservableInt(0);
    public final ObservableInt totalHouseholds = new ObservableInt(0);
    public final ObservableInt affectedHouseholds = new ObservableInt(0);
    public final ObservableInt displacedHouseholds = new ObservableInt(0);

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public FamilyDataViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context, newDncaGenInfoRepositoryManager);

        FamilyData familyData = mNewDncaGenInfoRepositoryManager.getFamilyData();
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
        mNewDncaGenInfoRepositoryManager.saveFamilyData(familyData);
    }
}
