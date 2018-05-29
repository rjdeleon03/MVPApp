package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageData;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsEnumBaseViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsRepositoryManager;

import java.util.List;

public class DamageCostViewModel extends LivelihoodsEnumBaseViewModel implements DamageCostRepositoryManager {

    /**
     * Constructor
     * @param context
     * @param livelihoodsRepositoryManager
     */
    public DamageCostViewModel(Context context, LivelihoodsRepositoryManager livelihoodsRepositoryManager) {
        super(context, livelihoodsRepositoryManager, GenericEnumDataRow.LivelihoodsType.class);
        mGenericEnumDataRows.addAll(mLivelihoodsRepositoryManager.getLivelihoodsDamageData().getLivelihoodsDamageDataRows());
    }

    /**
     * Handles navigation when save button is pressed
     */
    @Override
    public void navigateOnSaveButtonPressed() {
        LivelihoodsDamageData damageData = new LivelihoodsDamageData();
        damageData.setLivelihoodsDamageDataRows((List<LivelihoodsDamageDataRow>)(Object) mGenericEnumDataRows);
        mLivelihoodsRepositoryManager.saveLivelihoodsDamageData(damageData);
    }

    @Override
    public void addLivelihoodsDamageRow(LivelihoodsDamageDataRow damageDataRow) {
        super.addAgeGroupDataRow(damageDataRow);
    }

    @Override
    public void deleteLivelihoodsDamageRow(int rowIndex) {
        super.deleteAgeGroupDataRow(rowIndex);
    }

    @Override
    public LivelihoodsDamageDataRow getLivelihoodsDamageRow(int rowIndex) {
        return (LivelihoodsDamageDataRow) mGenericEnumDataRows.get(rowIndex);
    }

    @Override
    public GenericEnumDataRow.LivelihoodsType getLivelihoodsType(int livelihoodsTypeIndex) {
        return (GenericEnumDataRow.LivelihoodsType) ageGroupList.get(livelihoodsTypeIndex);
    }
}
