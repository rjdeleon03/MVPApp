package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.DeathCauseData.Row.DeathCauseDataRowViewModel;

public class DeathCauseDataFragmentAdapter extends EnumRowAdapter {

    private DeathCauseDataViewModel mViewModel;

    public DeathCauseDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         DeathCauseDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
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
