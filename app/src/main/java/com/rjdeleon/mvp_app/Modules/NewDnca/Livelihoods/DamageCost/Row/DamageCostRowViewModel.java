package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Row;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostRepositoryManager;

public class DamageCostRowViewModel extends BaseEnumRowViewModel {

    private DamageCostRepositoryManager mDamageCostRepositoryManager;

    public final ObservableList<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> affectedLivelihoods = new ObservableArrayList<>();
    public final ObservableInt damageCost = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param damageCostRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public DamageCostRowViewModel(Context context,
                                  DamageCostRepositoryManager damageCostRepositoryManager,
                                  BaseEnumNavigator baseEnumNavigator,
                                  int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mDamageCostRepositoryManager = damageCostRepositoryManager;

        LivelihoodsDamageDataRow damageDataRow = mDamageCostRepositoryManager.getLivelihoodsDamageRow(rowIndex);
        type.set(damageDataRow.getType());
        damageCost.set(damageDataRow.getDamageCost());
        remarks.set(damageDataRow.getRemarks());
        affectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());
        shouldShowRemarks.set(remarks.get().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mDamageCostRepositoryManager.deleteLivelihoodsDamageRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
