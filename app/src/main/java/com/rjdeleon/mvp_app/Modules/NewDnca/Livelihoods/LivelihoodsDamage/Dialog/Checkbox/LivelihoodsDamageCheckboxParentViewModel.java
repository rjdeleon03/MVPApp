package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox;

public interface LivelihoodsDamageCheckboxParentViewModel {

    LivelihoodsDamageCheckboxViewModel getAffectedLivelihoodViewModel(int index);

    int getAffectedLivelihoodsCount();
}