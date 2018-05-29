package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;

import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.LivelihoodsDamageDialogBinding;

public class DamageCostDialogFragment extends BaseEnumDialogFragment {

    private LivelihoodsDamageDialogBinding mBinding;

    public static DamageCostDialogFragment getInstance() {
        return new DamageCostDialogFragment();
    }

    public DamageCostDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.livelihoods_damage_dialog, null, false);
        mBinding.setViewModel((DamageCostDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
