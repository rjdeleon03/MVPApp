package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.AssistanceDialogBinding;

public class AssistanceDialogFragment extends BaseEnumDialogFragment {

    private AssistanceDialogBinding mBinding;

    public static AssistanceDialogFragment getInstance() {
        return new AssistanceDialogFragment();
    }

    public AssistanceDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.assistance_dialog, null, false);
        mBinding.setViewModel((AssistanceDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
