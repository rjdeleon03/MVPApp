package com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseCheckbox;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public interface BaseCheckboxParentViewModel {

    LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple getCheckboxItemAtPosition(int index);

    int getCheckboxesCount();
}
