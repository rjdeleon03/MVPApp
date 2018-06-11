package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox;

import android.databinding.ObservableBoolean;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;

public class LivelihoodsDamageCheckboxViewModel {

    public final ObservableBoolean isAffected = new ObservableBoolean(false);
    public final String text;

    public LivelihoodsDamageCheckboxViewModel(LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple enumBoolTuple) {
        isAffected.set(enumBoolTuple.isAffected);
        text = enumBoolTuple.subType.toString();
    }
}
