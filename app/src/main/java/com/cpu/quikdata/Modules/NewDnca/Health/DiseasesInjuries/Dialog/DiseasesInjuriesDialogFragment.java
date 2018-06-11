package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.DiseasesInjuriesFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.HealthDiseasesInjuriesDialogBinding;

public class DiseasesInjuriesDialogFragment extends BaseEnumDialogFragment {

    private HealthDiseasesInjuriesDialogBinding mBinding;

    public static DiseasesInjuriesDialogFragment newInstance() {
        return new DiseasesInjuriesDialogFragment();
    }

    public DiseasesInjuriesDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.health_diseases_injuries_dialog, null, false);
        mBinding.setViewModel((DiseasesInjuriesDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
