package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseAgeGroupDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataDialogBinding;

public class PopulationDataDialogFragment extends BaseAgeGroupDialogFragment {

    private PopulationDataDialogBinding mBinding;

    public static PopulationDataDialogFragment getInstance() {
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
