package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;

public class CasualtiesDataFragment extends TemplateEnumDataFragment<CasualtiesDataViewModel> {

    public CasualtiesDataFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.GEN_INFO_CASUALTIES.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static CasualtiesDataFragment newInstance() {

        return new CasualtiesDataFragment();
    }

    /**
     * Sets up the viewModel of the dialog
     * @return
     */
    @Override
    protected TemplateEnumDataDialogViewModel setupDialogViewModel(int index) {
        CasualtiesDataDialogViewModel casualtiesDataDialogViewModel =
                new CasualtiesDataDialogViewModel(Injection.provideDncaRepository(getContext()), index);
        casualtiesDataDialogViewModel.setViewComponent(this);
        casualtiesDataDialogViewModel.setDataManager(mViewModel);
        return casualtiesDataDialogViewModel;
    }
}
