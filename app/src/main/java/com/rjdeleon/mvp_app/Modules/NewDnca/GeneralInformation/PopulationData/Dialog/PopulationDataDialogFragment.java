package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataDialogBinding;

public class PopulationDataDialogFragment extends DialogFragment {

    private PopulationDataDialogViewModel mViewModel;
    private PopulationDataDialogBinding mBinding;

    public static PopulationDataDialogFragment newInstance() {
        return new PopulationDataDialogFragment();
    }

    public PopulationDataDialogFragment() {
        // Required empty public constructor
    }

    public void setViewModel(PopulationDataDialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.population_data_dialog, null, false);
        mBinding.setViewModel(mViewModel);
        View view = mBinding.getRoot();

        // Use builder for dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        return dialog;
    }
}
