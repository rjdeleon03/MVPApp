package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.IncomeSourceDataBefore;

import com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData.AssistanceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData.IncomeSourceDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class IncomeSourceDataBeforeFragment extends IncomeSourceDataFragment {

    public IncomeSourceDataBeforeFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_BEFORE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static IncomeSourceDataBeforeFragment newInstance() {

        return new IncomeSourceDataBeforeFragment();
    }
}
