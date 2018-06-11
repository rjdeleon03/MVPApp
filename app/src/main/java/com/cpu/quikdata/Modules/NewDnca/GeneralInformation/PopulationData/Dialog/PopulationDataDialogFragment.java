package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.PopulationDataDialogBinding;

public class PopulationDataDialogFragment extends BaseEnumDialogFragment {

    private PopulationDataDialogBinding mBinding;

    public static PopulationDataDialogFragment newInstance() {
        return new PopulationDataDialogFragment();
    }

    public PopulationDataDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.population_data_dialog, null, false);
        mBinding.setViewModel((PopulationDataDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
