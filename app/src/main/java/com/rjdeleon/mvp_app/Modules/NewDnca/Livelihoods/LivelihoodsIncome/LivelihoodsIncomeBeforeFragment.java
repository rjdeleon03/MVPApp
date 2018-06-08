package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_INCOME_BEFORE;

public class LivelihoodsIncomeBeforeFragment extends LivelihoodsIncomeFragment {

    public static LivelihoodsIncomeBeforeFragment newInstance() {
        return new LivelihoodsIncomeBeforeFragment();
    }

    public LivelihoodsIncomeBeforeFragment() {
        setFragmentTag(LIVELIHOODS_INCOME_BEFORE.toString());
    }
}
