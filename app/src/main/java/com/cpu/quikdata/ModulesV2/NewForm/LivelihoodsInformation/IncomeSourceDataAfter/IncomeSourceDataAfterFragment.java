package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataAfter;

import com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData.IncomeSourceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class IncomeSourceDataAfterFragment extends IncomeSourceDataFragment {

    public IncomeSourceDataAfterFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_AFTER.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static IncomeSourceDataAfterFragment newInstance() {

        return new IncomeSourceDataAfterFragment();
    }
}
