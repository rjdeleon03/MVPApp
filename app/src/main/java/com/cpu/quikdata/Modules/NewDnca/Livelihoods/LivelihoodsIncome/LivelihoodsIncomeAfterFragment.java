package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_INCOME_AFTER;

public class LivelihoodsIncomeAfterFragment extends LivelihoodsIncomeFragment {

    public static LivelihoodsIncomeAfterFragment newInstance() {
        return new LivelihoodsIncomeAfterFragment();
    }

    public LivelihoodsIncomeAfterFragment() {
        setFragmentTag(LIVELIHOODS_INCOME_AFTER.toString());
    }
}
