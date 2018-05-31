package com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;

import com.rjdeleon.mvp_app.databinding.HealthSpecialNeedsDialogBinding;
import com.rjdeleon.mvp_app.R;

public class SpecialNeedsDialogFragment extends BaseEnumDialogFragment {

    private HealthSpecialNeedsDialogBinding mBinding;

    public static SpecialNeedsDialogFragment getInstance() {
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
