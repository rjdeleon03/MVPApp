package com.cpu.quikdata.ModulesV2.NewForm.Common.IncomeSourceData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;

public abstract class IncomeSourceDataFragment extends TemplateEnumDataFragment<IncomeSourceDataViewModel> {

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        IncomeSourceDataDialogViewModel incomeSourceDataDialogViewModel =
                new IncomeSourceDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        incomeSourceDataDialogViewModel.setViewComponent(this);
        incomeSourceDataDialogViewModel.setDataManager(mViewModel);
        return incomeSourceDataDialogViewModel;
    }
}
