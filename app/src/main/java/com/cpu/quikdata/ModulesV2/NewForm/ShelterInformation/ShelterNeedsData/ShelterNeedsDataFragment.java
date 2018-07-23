package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.ShelterNeedsData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class ShelterNeedsDataFragment extends TemplateEnumDataFragment<ShelterNeedsDataViewModel> {

    public ShelterNeedsDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_NEEDS.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterNeedsDataFragment newInstance() {

        return new ShelterNeedsDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        ShelterNeedsDataDialogViewModel shelterNeedsDataDialogViewModel =
                new ShelterNeedsDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        shelterNeedsDataDialogViewModel.setViewComponent(this);
        shelterNeedsDataDialogViewModel.setDataManager(mViewModel);
        return shelterNeedsDataDialogViewModel;
    }
}
