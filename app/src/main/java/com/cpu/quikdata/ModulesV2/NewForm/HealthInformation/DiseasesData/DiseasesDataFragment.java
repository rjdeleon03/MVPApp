package com.cpu.quikdata.ModulesV2.NewForm.HealthInformation.DiseasesData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class DiseasesDataFragment extends TemplateEnumDataFragment<DiseasesDataViewModel> {

    public DiseasesDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.HEALTH_DISEASES.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static DiseasesDataFragment newInstance() {

        return new DiseasesDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        DiseasesDataDialogViewModel diseasesDataDialogViewModel =
                new DiseasesDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        diseasesDataDialogViewModel.setViewComponent(this);
        diseasesDataDialogViewModel.setDataManager(mViewModel);
        return diseasesDataDialogViewModel;
    }
}
