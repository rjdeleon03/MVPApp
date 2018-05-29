package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public interface DamageCostCheckboxParentViewModel {

    DamageCostCheckboxViewModel getAffectedLivelihoodViewModel(int index);

    int getAffectedLivelihoodsCount();
}
