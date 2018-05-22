package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterGapsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.ShelterInfo.ShelterGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.ShelterInfoRepositoryManager;

public class ShelterGapsDataViewModel extends ShelterInfoBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> hasSeparateCubicles= new ObservableField<>("");
    public final ObservableField<String> isAssistanceCulturallyAppropriate= new ObservableField<>("");
    public final ObservableField<String> isShelterAppropriate= new ObservableField<>("");
    public final ObservableField<String> hasAccessToBasicServices= new ObservableField<>("");
    public final ObservableField<String> hasAbleBodiedMember= new ObservableField<>("");
    public final ObservableField<String> hasReferralPathwayForGbv= new ObservableField<>("");
    public final ObservableField<String> hasGbvProtectionServices= new ObservableField<>("");
    public final ObservableField<String> hasGbvProtectionFocalPoint= new ObservableField<>("");
    
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
        ShelterGapsData shelterGapsData = new ShelterGapsData();
        shelterGapsData.setHasSeparateCubicles(hasSeparateCubicles.get());
        shelterGapsData.setIsAssistanceCulturallyAppropriate(isAssistanceCulturallyAppropriate.get());
        shelterGapsData.setIsShelterAppropriate(isShelterAppropriate.get());
        shelterGapsData.setHasAccessToBasicServices(hasAccessToBasicServices.get());
        shelterGapsData.setHasAbleBodiedMember(hasAbleBodiedMember.get());
        shelterGapsData.setHasReferralPathwayForGbv(hasReferralPathwayForGbv.get());
        shelterGapsData.setHasGbvProtectionServices(hasGbvProtectionServices.get());
        shelterGapsData.setHasGbvProtectionFocalPoint(hasGbvProtectionFocalPoint.get());
        mShelterInfoRepositoryManager.saveShelterGapsData(shelterGapsData);
    }
}
