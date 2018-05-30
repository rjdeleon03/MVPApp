package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.IncomeSourceDialogBinding;

public class LivelihoodsIncomeDialogFragment extends BaseEnumDialogFragment {

    private IncomeSourceDialogBinding mBinding;

    public static LivelihoodsIncomeDialogFragment getInstance() {
        return new LivelihoodsIncomeDialogFragment();
    }

    public LivelihoodsIncomeDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.income_source_dialog, null, false);
        mBinding.setViewModel((LivelihoodsIncomeDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
