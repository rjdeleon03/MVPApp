package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class DamageCostDialogViewModel extends BaseEnumDialogViewModel {

    private DamageCostRepositoryManager mDamageCostRepositoryManager;

    private List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> affectedLivelihoods = new ArrayList<>();
    public final ObservableInt damageCost = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     *
     * @param context
     */
    public DamageCostDialogViewModel(Context context,
                                     DamageCostRepositoryManager damageCostRepositoryManager,
                                     int livelihoodsTypeIndex,
                                     boolean isNewRow) {
        super(context);
        mDamageCostRepositoryManager = damageCostRepositoryManager;

        if (isNewRow) {
            type.set(mDamageCostRepositoryManager.getLivelihoodsType(livelihoodsTypeIndex));
        } else {

            LivelihoodsDamageDataRow damageDataRow = mDamageCostRepositoryManager.getLivelihoodsDamageRow(livelihoodsTypeIndex);
            type.set(damageDataRow.getType());
            damageCost.set(damageDataRow.getDamageCost());
            remarks.set(damageDataRow.getRemarks());
            affectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        LivelihoodsDamageDataRow damageDataRow = new LivelihoodsDamageDataRow(
                (GenericEnumDataRow.LivelihoodsType) type.get(),
                affectedLivelihoods,
                damageCost.get(),
                remarks.get());
        super.navigateOnOkButtonPressed();
    }
}
