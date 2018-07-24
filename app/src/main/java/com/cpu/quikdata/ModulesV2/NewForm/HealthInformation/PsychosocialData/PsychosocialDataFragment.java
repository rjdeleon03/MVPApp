package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.PsychosocialData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class PsychosocialDataFragment extends TemplateEnumDataFragment<PsychosocialDataViewModel> {

    public PsychosocialDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_PSYCHOSOCIAL.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static PsychosocialDataFragment newInstance() {

        return new PsychosocialDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        PsychosocialDataDialogViewModel psychosocialDataDialogViewModel =
                new PsychosocialDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        psychosocialDataDialogViewModel.setViewComponent(this);
        psychosocialDataDialogViewModel.setDataManager(mViewModel);
        return psychosocialDataDialogViewModel;
    }
}
