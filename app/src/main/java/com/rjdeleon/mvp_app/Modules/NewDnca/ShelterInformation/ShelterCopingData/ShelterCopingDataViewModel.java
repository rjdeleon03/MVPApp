package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Shelter.ShelterCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoRepositoryManager;

public class ShelterCopingDataViewModel extends ShelterInfoBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> evacuationSitesLocation = new ObservableField<>("");
    public final ObservableField<String> howToCope = new ObservableField<>("");
    public final ObservableField<String> whenToGoHome = new ObservableField<>("");
    public final ObservableField<String> whatIfCantGoHome = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterCopingDataViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager);

        ShelterCopingData copingData = mShelterInfoRepositoryManager.getShelterCopingData();
        evacuationSitesLocation.set(copingData.getEvacuationSitesLocation());
        howToCope.set(copingData.getHowToCope());
        whenToGoHome.set(copingData.getWhenToGoHome());
        whatIfCantGoHome.set(copingData.getWhatIfCantGoHome());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterCopingData copingData = new ShelterCopingData(
                evacuationSitesLocation.get(),
                howToCope.get(),
                whenToGoHome.get(),
                whatIfCantGoHome.get());
        mShelterInfoRepositoryManager.saveShelterCopingData(copingData);
    }

}
