package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.EvacuationPopulationDialogBinding;

public class EvacuationPopulationDialogFragment extends BaseEnumDialogFragment {

    private EvacuationPopulationDialogBinding mBinding;


    public static EvacuationPopulationDialogFragment newInstance() {
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
