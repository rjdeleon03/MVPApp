package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row.VulnerablePopulationRowViewModel;

public class VulnerablePopulationFragmentAdapter extends EnumRowAdapter {

    private VulnerablePopulationViewModel mViewModel;

    public VulnerablePopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               VulnerablePopulationViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        VulnerablePopulationRowViewModel vulnerablePopulationRowViewModel =
                new VulnerablePopulationRowViewModel(mContext, mViewModel, mBaseEnumNavigator, position);
        holder.bind(vulnerablePopulationRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
