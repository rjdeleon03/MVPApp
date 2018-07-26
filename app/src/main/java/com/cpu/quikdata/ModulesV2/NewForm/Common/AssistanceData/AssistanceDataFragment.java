package com.cpu.quikdata.ModulesV2.NewForm.Common.AssistanceData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;

public abstract class AssistanceDataFragment extends TemplateEnumDataFragment<AssistanceDataViewModel> {

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
