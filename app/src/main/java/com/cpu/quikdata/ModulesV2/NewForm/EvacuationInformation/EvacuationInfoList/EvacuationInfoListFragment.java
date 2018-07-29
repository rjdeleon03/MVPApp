package com.cpu.quikdata.ModulesV2.NewForm.EvacuationInformation.EvacuationInfoList;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class EvacuationInfoListFragment extends TemplateEnumDataFragment<EvacuationInfoListViewModel> {

    public EvacuationInfoListFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.EVACUATION.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static EvacuationInfoListFragment newInstance() {

        return new EvacuationInfoListFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        EvacuationInfoListDialogViewModel evacuationInfoListDialogViewModel =
                new EvacuationInfoListDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        evacuationInfoListDialogViewModel.setViewComponent(this);
        evacuationInfoListDialogViewModel.setDataManager(mViewModel);
        return evacuationInfoListDialogViewModel;
    }
}
