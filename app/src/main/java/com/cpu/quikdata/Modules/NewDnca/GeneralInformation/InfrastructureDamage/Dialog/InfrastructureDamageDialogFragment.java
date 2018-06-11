package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.InfrastructureDamageDialogBinding;

public class InfrastructureDamageDialogFragment extends BaseEnumDialogFragment {

    private InfrastructureDamageDialogBinding mBinding;

    public static InfrastructureDamageDialogFragment newInstance() {
        return new InfrastructureDamageDialogFragment();
    }

    public InfrastructureDamageDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.infrastructure_damage_dialog, null, false);
        mBinding.setViewModel((InfrastructureDamageDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
