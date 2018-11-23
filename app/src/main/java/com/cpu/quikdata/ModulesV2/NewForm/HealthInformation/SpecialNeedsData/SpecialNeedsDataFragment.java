package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.SpecialNeedsData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class SpecialNeedsDataFragment extends TemplateEnumDataFragment<SpecialNeedsDataViewModel> {

    public SpecialNeedsDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_SPECIAL_NEEDS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static SpecialNeedsDataFragment newInstance() {

        return new SpecialNeedsDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        SpecialNeedsDataDialogViewModel specialNeedsDataDialogViewModel =
                new SpecialNeedsDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        specialNeedsDataDialogViewModel.setViewComponent(this);
        specialNeedsDataDialogViewModel.setDataManager(mViewModel);
        return specialNeedsDataDialogViewModel;
    }
}
