package com.rjdeleon.mvp_app.Modules.NewDnca.Evacuation.EvacuationPopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.EvacuationPopulationDialogBinding;

public class EvacuationPopulationDialogFragment extends BaseEnumDialogFragment {

    private EvacuationPopulationDialogBinding mBinding;


    public static EvacuationPopulationDialogFragment getInstance() {
        return new EvacuationPopulationDialogFragment();
    }

    public EvacuationPopulationDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.evacuation_population_dialog, null, false);
        mBinding.setViewModel((EvacuationPopulationDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
