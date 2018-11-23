package com.cpu.quikdata.ModulesV2.NewForm.LivelihoodsInformation.DamageCostData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class DamageCostDataFragment extends TemplateEnumDataFragment<DamageCostDataViewModel> {

    public DamageCostDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.LIVELIHOODS_DAMAGE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static DamageCostDataFragment newInstance() {

        return new DamageCostDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        DamageCostDataDialogViewModel damageCostDataDialogViewModel =
                new DamageCostDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        damageCostDataDialogViewModel.setViewComponent(this);
        damageCostDataDialogViewModel.setDataManager(mViewModel);
        return damageCostDataDialogViewModel;
    }
}
