package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.HouseDamageData.Dialog;


import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.HouseDamageDialogBinding;

public class HouseDamageDialogFragment extends BaseEnumDialogFragment {

    private HouseDamageDialogBinding mBinding;

    public static HouseDamageDialogFragment getInstance() {
        return new HouseDamageDialogFragment();
    }

    public HouseDamageDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.shelter_house_damage_dialog, null, false);
        mBinding.setViewModel((HouseDamageDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
