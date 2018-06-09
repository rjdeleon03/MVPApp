package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import static com.rjdeleon.mvp_app.AppConstants.LivelihoodsComponent.LIVELIHOODS_INCOME_AFTER;

public class LivelihoodsIncomeAfterFragment extends LivelihoodsIncomeFragment {

    public static LivelihoodsIncomeAfterFragment newInstance() {
        return new LivelihoodsIncomeAfterFragment();
    }

    public LivelihoodsIncomeAfterFragment() {
        setFragmentTag(LIVELIHOODS_INCOME_AFTER.toString());
    }
}
