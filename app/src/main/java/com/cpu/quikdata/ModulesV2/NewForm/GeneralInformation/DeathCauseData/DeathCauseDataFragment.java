package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.DeathCauseData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class DeathCauseDataFragment extends TemplateEnumDataFragment<DeathCauseDataViewModel> {

    public DeathCauseDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_DEATH_CAUSE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static DeathCauseDataFragment newInstance() {

        return new DeathCauseDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        DeathCauseDataDialogViewModel deathCauseDataDialogViewModel =
                new DeathCauseDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        deathCauseDataDialogViewModel.setViewComponent(this);
        deathCauseDataDialogViewModel.setDataManager(mViewModel);
        return deathCauseDataDialogViewModel;
    }
}
