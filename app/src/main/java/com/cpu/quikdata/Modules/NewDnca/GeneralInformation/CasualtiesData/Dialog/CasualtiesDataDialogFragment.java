package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.CasualtiesDataDialogBinding;

public class CasualtiesDataDialogFragment extends BaseEnumDialogFragment {

    private CasualtiesDataDialogBinding mBinding;

    public static CasualtiesDataDialogFragment newInstance() {
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
