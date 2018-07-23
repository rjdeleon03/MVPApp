package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class DamageDataFragment extends TemplateEnumDataFragment<DamageDataViewModel> {

    public DamageDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO_DAMAGE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static DamageDataFragment newInstance() {

        return new DamageDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        DamageDataDialogViewModel damageDataDialogViewModel =
                new DamageDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        damageDataDialogViewModel.setViewComponent(this);
        damageDataDialogViewModel.setDataManager(mViewModel);
        return damageDataDialogViewModel;
    }
}
