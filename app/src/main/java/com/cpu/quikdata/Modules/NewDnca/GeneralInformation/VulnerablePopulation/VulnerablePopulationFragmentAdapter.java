package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row.VulnerablePopulationRowViewModel;

public class VulnerablePopulationFragmentAdapter extends BaseEnumRowAdapter {

    private VulnerablePopulationViewModel mViewModel;

    public VulnerablePopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               VulnerablePopulationViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        VulnerablePopulationRowViewModel vulnerablePopulationRowViewModel =
                new VulnerablePopulationRowViewModel(mContext, mViewModel, mBaseEnumNavigator, position);
        holder.bind(vulnerablePopulationRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
