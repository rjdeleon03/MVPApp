package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseAgeGroupDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.CasualtiesDataDialogBinding;

public class CasualtiesDataDialogFragment extends BaseAgeGroupDialogFragment {

    private CasualtiesDataDialogBinding mBinding;

    public static CasualtiesDataDialogFragment getInstance() {
        return new CasualtiesDataDialogFragment();
    }

    public CasualtiesDataDialogFragment() {
        // Required empty public constructor
    }

    public void setViewModel(CasualtiesDataDialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.casualties_data_dialog, null, false);
        mBinding.setViewModel((CasualtiesDataDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
