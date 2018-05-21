package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.Generics.SimpleDate;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoRepositoryManager;

public class CalamityDetailsViewModel extends GenInfoBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> calamityType = new ObservableField<>("");
    public final ObservableField<SimpleDate> dateOccurred = new ObservableField<>(new SimpleDate());
    public final ObservableField<String> eventDescription = new ObservableField<>("");
    public final ObservableField<String> areaDescription = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param genInfoRepositoryManager
     */
    public CalamityDetailsViewModel(Context context, GenInfoRepositoryManager genInfoRepositoryManager) {
        super(context, genInfoRepositoryManager);

        CalamityDesc calamityDesc = mGenInfoRepositoryManager.getCalamityDetails();
        calamityType.set(calamityDesc.getCalamityType());
        dateOccurred.set(calamityDesc.getDateOccurred());
        eventDescription.set(calamityDesc.getEventDescription());
        areaDescription.set(calamityDesc.getAreaDescription());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        CalamityDesc calamityDesc = new CalamityDesc();
        calamityDesc.setCalamityType(calamityType.get());
        calamityDesc.setDateOccurred(dateOccurred.get());
        calamityDesc.setEventDescription(eventDescription.get());
        calamityDesc.setAreaDescription(areaDescription.get());
        mGenInfoRepositoryManager.saveCalamityDetails(calamityDesc);
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
