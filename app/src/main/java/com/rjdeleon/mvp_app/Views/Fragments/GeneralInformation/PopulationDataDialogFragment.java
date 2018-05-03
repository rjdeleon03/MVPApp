package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataDialogContract;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataDialogBinding;

public class PopulationDataDialogFragment extends DialogFragment implements PopulationDataDialogContract.View {

    private PopulationDataDialogBinding mBinding;
    private PopulationDataDialogContract.Presenter mPresenter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.population_data_dialog, null, false);
        mBinding.setPresenter(mPresenter);
        View view = mBinding.getRoot();

        // Use builder for dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        return dialog;
    }

    @Override
    public void bind(PopulationDataDialogContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onDialogCancelButtonClick(View view) {
        dismiss();
    }
}
