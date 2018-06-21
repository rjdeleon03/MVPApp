package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewModel;

public class PopulationDataFragmentAdapter extends BaseEnumRowAdapter {

    private PopulationDataViewModel mViewModel;

    public PopulationDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         PopulationDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        PopulationDataRowViewModel populationDataRowViewModel = new PopulationDataRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(populationDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
