package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row.InfrastructureDamageRowViewModel;

public class InfrastructureDamageFragmentAdapter extends BaseEnumRowAdapter {

    private InfrastructureDamageViewModel mViewModel;

    public InfrastructureDamageFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               InfrastructureDamageViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        InfrastructureDamageRowViewModel infrastructureDamageRowViewModel = new InfrastructureDamageRowViewModel(
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
