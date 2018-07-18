package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class PopulationDataFragment extends TemplateEnumDataFragment<PopulationDataViewModel> {

    public PopulationDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_POPULATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static PopulationDataFragment newInstance() {

        return new PopulationDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        PopulationDataDialogViewModel populationDataDialogViewModel =
                new PopulationDataDialogViewModel(Injection.provideDncaRepository(getActivity()), index);
        populationDataDialogViewModel.setViewComponent(mViewModel);
        return populationDataDialogViewModel;
    }
}
