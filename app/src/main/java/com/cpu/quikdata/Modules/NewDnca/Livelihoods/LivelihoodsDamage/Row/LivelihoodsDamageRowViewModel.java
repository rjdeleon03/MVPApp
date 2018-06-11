package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageRepositoryManager;

public class LivelihoodsDamageRowViewModel extends BaseEnumRowViewModel {

    private LivelihoodsDamageRepositoryManager mLivelihoodsDamageRepositoryManager;

    public final ObservableList<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> affectedLivelihoods = new ObservableArrayList<>();
    public final ObservableInt damageCost = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     * @param context
     * @param livelihoodsDamageRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public LivelihoodsDamageRowViewModel(Context context,
                                         LivelihoodsDamageRepositoryManager livelihoodsDamageRepositoryManager,
                                         BaseEnumNavigator baseEnumNavigator,
                                         int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
        mLivelihoodsDamageRepositoryManager = livelihoodsDamageRepositoryManager;

        LivelihoodsDamageDataRow damageDataRow = mLivelihoodsDamageRepositoryManager.getLivelihoodsDamageRow(rowIndex);
        type.set(damageDataRow.getType());
        damageCost.set(damageDataRow.getDamageCost());
        remarks.set(damageDataRow.getRemarks());
        affectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());
        shouldShowRemarks.set(remarks.get().trim().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mLivelihoodsDamageRepositoryManager.deleteLivelihoodsDamageRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
