package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsGapsData;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.rjdeleon.mvp_app.Models.Generics.BoolRemarksTuple;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsGapsData;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.NonEnumSaveableSection;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

public class LivelihoodsGapsDataViewModel extends LivelihoodsBaseViewModel implements NonEnumSaveableSection {

    public final ObservableBoolean localMarketBool = new ObservableBoolean(false);
    public final ObservableField<String> localMarketRemarks = new ObservableField<>("");
    public final ObservableBoolean opportunitiesBool = new ObservableBoolean(false);
    public final ObservableField<String> opportunitiesRemarks = new ObservableField<>("");
    public final ObservableBoolean creditBool = new ObservableBoolean(false);
    public final ObservableField<String> creditRemarks = new ObservableField<>("");
    public final ObservableBoolean livelihoodMaterialsBool = new ObservableBoolean(false);
    public final ObservableField<String> livelihoodMaterialsRemarks = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public LivelihoodsGapsDataViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager);

        LivelihoodsGapsData gapsData = mLivelihoodsRepositoryManager.getLivelihoodsGapsData();
        localMarketBool.set(gapsData.getLocalMarket().isYes);
        localMarketRemarks.set(gapsData.getLocalMarket().remarks);
        opportunitiesBool.set(gapsData.getOpportunities().isYes);
        opportunitiesRemarks.set(gapsData.getOpportunities().remarks);
        creditBool.set(gapsData.getCredit().isYes);
        creditRemarks.set(gapsData.getCredit().remarks);
        livelihoodMaterialsBool.set(gapsData.getLivelihoodMaterials().isYes);
        livelihoodMaterialsRemarks.set(gapsData.getLivelihoodMaterials().remarks);
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsGapsData gapsData = new LivelihoodsGapsData(
                new BoolRemarksTuple(localMarketBool.get(), localMarketRemarks.get()),
                new BoolRemarksTuple(opportunitiesBool.get(), opportunitiesRemarks.get()),
                new BoolRemarksTuple(creditBool.get(), creditRemarks.get()),
                new BoolRemarksTuple(livelihoodMaterialsBool.get(), livelihoodMaterialsRemarks.get()));
        mLivelihoodsRepositoryManager.saveLivelihoodsGapsData(gapsData);
    }
}
