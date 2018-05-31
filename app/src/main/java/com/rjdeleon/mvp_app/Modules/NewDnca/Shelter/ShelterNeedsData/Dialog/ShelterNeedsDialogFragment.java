package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.ShelterNeedsDialogBinding;

public class ShelterNeedsDialogFragment extends BaseEnumDialogFragment {

    private ShelterNeedsDialogBinding mBinding;

    public static ShelterNeedsDialogFragment getInstance() {
        return new ShelterNeedsDialogFragment();
    }

    public ShelterNeedsDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.shelter_needs_dialog, null, false);
        mBinding.setViewModel((ShelterNeedsDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
