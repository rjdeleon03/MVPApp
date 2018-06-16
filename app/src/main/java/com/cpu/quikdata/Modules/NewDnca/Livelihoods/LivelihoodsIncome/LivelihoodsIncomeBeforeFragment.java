package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_INCOME_BEFORE;

public class LivelihoodsIncomeBeforeFragment extends LivelihoodsIncomeFragment {

    public static LivelihoodsIncomeBeforeFragment newInstance() {
        return new LivelihoodsIncomeBeforeFragment();
    }

    public LivelihoodsIncomeBeforeFragment() {
        setFragmentTag(LIVELIHOODS_INCOME_BEFORE.toString());
    }
}
