package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoRepositoryManager;

public class ShelterCopingDataViewModel extends ShelterInfoBaseViewModel {

    public final ObservableField<String> evacuationSitesLocation = new ObservableField<>("");
    public final ObservableField<String> howToCope = new ObservableField<>("");
    public final ObservableField<String> whenToGoHome = new ObservableField<>("");
    public final ObservableField<String> whatIfCantGoHome = new ObservableField<>("");

    /**
     * Constructor
     *
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterCopingDataViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager);

        ShelterCopingData shelterCopingData = mShelterInfoRepositoryManager.getShelterCopingData();
        evacuationSitesLocation.set(shelterCopingData.getEvacuationSitesLocation());
        howToCope.set(shelterCopingData.getHowToCope());
        whenToGoHome.set(shelterCopingData.getWhenToGoHome());
        whatIfCantGoHome.set(shelterCopingData.getWhatIfCantGoHome());
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {
        ShelterCopingData shelterCopingData = new ShelterCopingData();
        shelterCopingData.setEvacuationSitesLocation(evacuationSitesLocation.get());
        shelterCopingData.setHowToCope(howToCope.get());
        shelterCopingData.setWhenToGoHome(whenToGoHome.get());
        shelterCopingData.setWhatIfCantGoHome(whatIfCantGoHome.get());
    }

}
