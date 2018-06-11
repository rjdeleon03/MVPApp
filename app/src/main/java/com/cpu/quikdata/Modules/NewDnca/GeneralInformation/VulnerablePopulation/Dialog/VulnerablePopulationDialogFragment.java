package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.VulnerablePopulationDialogBinding;

public class VulnerablePopulationDialogFragment extends BaseEnumDialogFragment {

    private VulnerablePopulationDialogBinding mBinding;

    public static VulnerablePopulationDialogFragment newInstance() {
        return new VulnerablePopulationDialogFragment();
    }

    public VulnerablePopulationDialogFragment() {
        // Required empty public constructor
    }

    public void setViewModel(VulnerablePopulationDialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.vulnerable_population_dialog, null, false);
        mBinding.setViewModel((VulnerablePopulationDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
