package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox;

import android.databinding.ObservableBoolean;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public class DamageCostCheckboxViewModel {

    public final ObservableBoolean isAffected = new ObservableBoolean(false);
    public final String text;

    public DamageCostCheckboxViewModel(LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple enumBoolTuple) {
        isAffected.set(enumBoolTuple.isAffected);
        text = enumBoolTuple.subType.toString();
    }
}
