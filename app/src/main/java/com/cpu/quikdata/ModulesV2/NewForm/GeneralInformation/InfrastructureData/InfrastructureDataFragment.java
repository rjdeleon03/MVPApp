package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.InfrastructureData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class InfrastructureDataFragment extends TemplateEnumDataFragment<InfrastructureDataViewModel> {

    public InfrastructureDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_POPULATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static InfrastructureDataFragment newInstance() {

        return new InfrastructureDataFragment();
    }

    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        InfrastructureDataDialogViewModel infrastructureDataDialogViewModel =
                new InfrastructureDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        infrastructureDataDialogViewModel.setViewComponent(this);
        infrastructureDataDialogViewModel.setDataManager(mViewModel);
        return infrastructureDataDialogViewModel;
    }
}
