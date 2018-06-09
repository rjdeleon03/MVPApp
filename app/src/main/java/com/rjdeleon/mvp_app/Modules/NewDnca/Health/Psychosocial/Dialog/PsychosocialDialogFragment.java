package com.rjdeleon.mvp_app.Modules.NewDnca.Health.Psychosocial.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.databinding.HealthPsychosocialDialogBinding;
import com.rjdeleon.mvp_app.R;

public class PsychosocialDialogFragment extends BaseEnumDialogFragment {

    private HealthPsychosocialDialogBinding mBinding;

    public static PsychosocialDialogFragment newInstance() {
        return new PsychosocialDialogFragment();
    }

    public PsychosocialDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.health_psychosocial_dialog, null, false);
        mBinding.setViewModel((PsychosocialDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
