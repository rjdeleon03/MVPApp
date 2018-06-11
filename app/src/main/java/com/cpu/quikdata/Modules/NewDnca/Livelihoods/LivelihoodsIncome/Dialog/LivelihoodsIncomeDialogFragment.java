package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.LivelihoodsIncomeSourceDialogBinding;

public class LivelihoodsIncomeDialogFragment extends BaseEnumDialogFragment {

    private LivelihoodsIncomeSourceDialogBinding mBinding;

    public static LivelihoodsIncomeDialogFragment newInstance() {
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
        mBinding = DataBindingUtil.inflate(inflater, R.layout.livelihoods_income_source_dialog, null, false);
        mBinding.setViewModel((LivelihoodsIncomeDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
