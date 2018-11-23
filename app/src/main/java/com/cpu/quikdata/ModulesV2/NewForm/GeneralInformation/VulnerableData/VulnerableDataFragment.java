package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class VulnerableDataFragment extends TemplateEnumDataFragment<VulnerableDataViewModel> {

    public VulnerableDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_VULNERABLE.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static VulnerableDataFragment newInstance() {

        return new VulnerableDataFragment();
    }

    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        VulnerableDataDialogViewModel vulnerableDataDialogViewModel =
                new VulnerableDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        vulnerableDataDialogViewModel.setViewComponent(this);
        vulnerableDataDialogViewModel.setDataManager(mViewModel);
        return vulnerableDataDialogViewModel;
    }
}
