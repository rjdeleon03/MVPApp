package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row.DeathCauseDataRowViewModel;

public class DeathCauseDataFragmentAdapter extends BaseEnumRowAdapter {

    private DeathCauseDataViewModel mViewModel;

    public DeathCauseDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         DeathCauseDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        DeathCauseDataRowViewModel deathCauseDataRowViewModel = new DeathCauseDataRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(deathCauseDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
