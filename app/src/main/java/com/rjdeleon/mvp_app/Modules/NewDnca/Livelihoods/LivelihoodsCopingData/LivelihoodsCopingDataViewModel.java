package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsCopingData;

import android.content.Context;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsCopingData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsCopingDataViewModel extends LivelihoodsBaseViewModel implements NonEnumSaveableSection {

    public final ObservableField<String> copingStrategies = new ObservableField<>();
    public final ObservableField<String> incomeOpportunities = new ObservableField<>(); 
    public final ObservableField<String> livelihoodSkills = new ObservableField<>();

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsCopingDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsCopingData copingData = mLivelihoodsRepositoryManager.getLivelihoodsCopingData();
        copingStrategies.set(copingData.getCopingStrategies());
        incomeOpportunities.set(copingData.getIncomeOpportunities());
        livelihoodSkills.set(copingData.getLivelihoodSkills());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsCopingData copingData = new LivelihoodsCopingData(
                copingStrategies.get(),
                incomeOpportunities.get(),
                livelihoodSkills.get());
        mLivelihoodsRepositoryManager.saveLivelihoodsCopingData(copingData);
    }
}
