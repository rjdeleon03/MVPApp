package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogFragment;

public class CasualtiesDataDialogFragment extends BaseAgeGroupDialogFragment {


    public static CasualtiesDataDialogFragment getInstance() {
        return new CasualtiesDataDialogFragment();
    }

    public CasualtiesDataDialogFragment() {
        // Required empty public constructor
    }

    public void setViewModel(CasualtiesDataDialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.population_data_dialog, null, false);
        mBinding.setViewModel((PopulationDataDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
    */
}
