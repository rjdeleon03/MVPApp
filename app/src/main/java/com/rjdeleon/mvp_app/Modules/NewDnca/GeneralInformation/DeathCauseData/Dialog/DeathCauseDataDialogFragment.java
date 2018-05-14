package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog.PopulationDataDialogViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DeathCauseDataDialogBinding;

public class DeathCauseDataDialogFragment extends BaseAgeGroupDialogFragment {

    private DeathCauseDataDialogBinding mBinding;

    public static DeathCauseDataDialogFragment getInstance() {
        return new DeathCauseDataDialogFragment();
    }

    public DeathCauseDataDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.death_cause_data_dialog, null, false);
        mBinding.setViewModel((DeathCauseDataDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
