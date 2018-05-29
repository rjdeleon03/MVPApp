package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsNeedsData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsNeedsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsNeedsDataViewModel extends LivelihoodsBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> assistanceToFillGap = new ObservableField<>("");
    public final ObservableField<String> resourcesNeeded = new ObservableField<>("");
    public final ObservableField<String> familiesNeedingAssistance = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsNeedsDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsNeedsData needsData = mLivelihoodsRepositoryManager.getLivelihoodsNeedsData();
        assistanceToFillGap.set(needsData.getAssistanceToFillGap());
        resourcesNeeded.set(needsData.getResourcesNeeded());
        familiesNeedingAssistance.set(needsData.getFamiliesNeedingAssistance());
    }


    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsNeedsData needsData = new LivelihoodsNeedsData(
                assistanceToFillGap.get(),
                resourcesNeeded.get(),
                familiesNeedingAssistance.get());
        mLivelihoodsRepositoryManager.saveLivelihoodsNeedsData(needsData);
    }
}
