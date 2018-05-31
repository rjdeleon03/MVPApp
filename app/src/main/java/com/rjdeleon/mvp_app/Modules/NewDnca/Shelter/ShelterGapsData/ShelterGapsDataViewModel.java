package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Shelter.ShelterGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterInfoRepositoryManager;

public class ShelterGapsDataViewModel extends ShelterInfoBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> hasSeparateCubicles = new ObservableField<>("");
    public final ObservableField<String> isAssistanceCulturallyAppropriate = new ObservableField<>("");
    public final ObservableField<String> isShelterAppropriate = new ObservableField<>("");
    public final ObservableField<String> hasAccessToBasicServices = new ObservableField<>("");
    public final ObservableField<String> hasAbleBodiedMember = new ObservableField<>("");
    public final ObservableField<String> hasReferralPathwayForGbv = new ObservableField<>("");
    public final ObservableField<String> hasGbvProtectionServices = new ObservableField<>("");
    public final ObservableField<String> hasGbvProtectionFocalPoint = new ObservableField<>("");
    
    /**
     * Constructor
     * @param context
     * @param shelterInfoRepositoryManager
     */
    public ShelterGapsDataViewModel(Context context, ShelterInfoRepositoryManager shelterInfoRepositoryManager) {
        super(context, shelterInfoRepositoryManager);

        ShelterGapsData shelterGapsData = mShelterInfoRepositoryManager.getShelterGapsData();
        hasSeparateCubicles.set(shelterGapsData.getHasSeparateCubicles());
        isAssistanceCulturallyAppropriate.set(shelterGapsData.getIsAssistanceCulturallyAppropriate());
        isShelterAppropriate.set(shelterGapsData.getIsShelterAppropriate());
        hasAccessToBasicServices.set(shelterGapsData.getHasAccessToBasicServices());
        hasAbleBodiedMember.set(shelterGapsData.getHasAbleBodiedMember());
        hasReferralPathwayForGbv.set(shelterGapsData.getHasReferralPathwayForGbv());
        hasGbvProtectionServices.set(shelterGapsData.getHasGbvProtectionServices());
        hasGbvProtectionFocalPoint.set(shelterGapsData.getHasGbvProtectionFocalPoint());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        ShelterGapsData shelterGapsData = new ShelterGapsData(hasSeparateCubicles.get(),
                isAssistanceCulturallyAppropriate.get(),
                isShelterAppropriate.get(),
                hasAccessToBasicServices.get(),
                hasAbleBodiedMember.get(),
                hasReferralPathwayForGbv.get(),
                hasGbvProtectionServices.get(),
                hasGbvProtectionFocalPoint.get());
        mShelterInfoRepositoryManager.saveShelterGapsData(shelterGapsData);
    }
}
