package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;

import com.cpu.quikdata.databinding.HealthSpecialNeedsDialogBinding;
import com.cpu.quikdata.R;

public class SpecialNeedsDialogFragment extends BaseEnumDialogFragment {

    private HealthSpecialNeedsDialogBinding mBinding;

    public static SpecialNeedsDialogFragment newInstance() {
        return new SpecialNeedsDialogFragment();
    }

    public SpecialNeedsDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.health_special_needs_dialog, null, false);
        mBinding.setViewModel((SpecialNeedsDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
