package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row.InfrastructureDamageRowViewModel;

public class InfrastructureDamageFragmentAdapter extends EnumRowAdapter {

    private InfrastructureDamageViewModel mViewModel;

    public InfrastructureDamageFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               InfrastructureDamageViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        InfrastructureDamageRowViewModel infrastructureDamageRowViewModel = new InfrastructureDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(infrastructureDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
