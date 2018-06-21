package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationItem.EvacuationPopulationData.Row.EvacuationPopulationRowViewModel;

public class EvacuationPopulationFragmentAdapter extends BaseEnumRowAdapter {

    private EvacuationPopulationViewModel mViewModel;

    public EvacuationPopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               EvacuationPopulationViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
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
