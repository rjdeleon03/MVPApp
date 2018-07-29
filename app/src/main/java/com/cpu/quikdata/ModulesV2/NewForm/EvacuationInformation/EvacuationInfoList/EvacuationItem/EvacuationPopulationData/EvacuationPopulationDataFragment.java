package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList.EvacuationItem.EvacuationPopulationData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationPopulationDataFragment extends TemplateEnumDataFragment<EvacuationPopulationDataViewModel> {

    public EvacuationPopulationDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION_ITEM_POPULATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationPopulationDataFragment newInstance() {

        return new EvacuationPopulationDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        EvacuationPopulationDataDialogViewModel evacuationPopulationDataDialogViewModel =
                new EvacuationPopulationDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        evacuationPopulationDataDialogViewModel.setViewComponent(this);
        evacuationPopulationDataDialogViewModel.setDataManager(mViewModel);
        return evacuationPopulationDataDialogViewModel;
    }
}
