package com.cpu.quikdata.ModulesV2.NewForm.Common;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class AssistanceDataFragment extends TemplateEnumDataFragment<AssistanceDataViewModel> {

    public AssistanceDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_ASSISTANCE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static AssistanceDataFragment newInstance() {

        return new AssistanceDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        AssistanceDataDialogViewModel assistanceDataDialogViewModel =
                new AssistanceDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        assistanceDataDialogViewModel.setViewComponent(this);
        assistanceDataDialogViewModel.setDataManager(mViewModel);
        return assistanceDataDialogViewModel;
    }
}
