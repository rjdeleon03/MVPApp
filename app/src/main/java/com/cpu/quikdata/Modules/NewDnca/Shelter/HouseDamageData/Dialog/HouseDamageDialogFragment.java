package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Dialog;


import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.ShelterHouseDamageDialogBinding;

public class HouseDamageDialogFragment extends BaseEnumDialogFragment {

    private ShelterHouseDamageDialogBinding mBinding;

    public static HouseDamageDialogFragment newInstance() {
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
