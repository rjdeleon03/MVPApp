package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Row.EvacuationPopulationRowViewModel;

public class EvacuationPopulationFragmentAdapter extends EnumRowAdapter {

    private EvacuationPopulationViewModel mViewModel;

    public EvacuationPopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               EvacuationPopulationViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        EvacuationPopulationRowViewModel evacuationPopulationRowViewModel = new EvacuationPopulationRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(evacuationPopulationRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
