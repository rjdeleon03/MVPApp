package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.DeathCauseDataDialogBinding;

public class DeathCauseDataDialogFragment extends BaseEnumDialogFragment {

    private DeathCauseDataDialogBinding mBinding;

    public static DeathCauseDataDialogFragment newInstance() {
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
