package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.DNCAForm;
import com.rjdeleon.mvp_app.Models.DNCAFormDataSource;
import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.NewDncaGenInfoRepositoryManager;

public class CalamityDetailsViewModel extends NewDncaBaseViewModel {

    private NewDncaGenInfoRepositoryManager mNewDncaGenInfoRepositoryManager;

    public ObservableField<String> calamityType;
    public ObservableField<SimpleDate> dateOccurred;
    public ObservableField<String> eventDescription;
    public ObservableField<String> areaDescription;

    /**
     * Constructor
     * @param context
     * @param newDncaGenInfoRepositoryManager
     */
    public CalamityDetailsViewModel(Context context, NewDncaGenInfoRepositoryManager newDncaGenInfoRepositoryManager) {
        super(context);
        mNewDncaGenInfoRepositoryManager = newDncaGenInfoRepositoryManager;

        CalamityDesc calamityDesc = mNewDncaGenInfoRepositoryManager.getCalamityDetails();
        calamityType = new ObservableField<>(calamityDesc.getCalamityType());
        dateOccurred = new ObservableField<>(calamityDesc.getDateOccurred());
        eventDescription = new ObservableField<>(calamityDesc.getEventDescription());
        areaDescription = new ObservableField<>(calamityDesc.getAreaDescription());
    }

    /**
     * Handles navigation when save button is pressed
     */
    public void navigateOnSaveButtonPressed() {
        CalamityDesc calamityDesc = new CalamityDesc();
        calamityDesc.setCalamityType(calamityType.get());
        calamityDesc.setDateOccurred(dateOccurred.get());
        calamityDesc.setEventDescription(eventDescription.get());
        calamityDesc.setAreaDescription(areaDescription.get());
        mNewDncaGenInfoRepositoryManager.saveCalamityDetails(calamityDesc);
    }

    /**
     * Sets the assessment date
     * @param year
     * @param month
     * @param day
     */
    public void onDateOccurredSet(int year, int month, int day) {
        dateOccurred.set(new SimpleDate(year, month, day));
    }
}
