package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model;

import com.cpu.quikdata.Models.Generics.SimpleDate;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;

import java.util.List;

public class DialogItemModelRecycler extends DialogItemModel {

    private List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> values;

    public DialogItemModelRecycler(String text, List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> values) {
        super(text);
        this.values = values;
    }

    public List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> getValues() {
        return values;
    }

    public void setValues(List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> value1) {
        this.values = value1;
    }
}
