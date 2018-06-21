package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row.PsychosocialRowViewModel;

public class PsychosocialFragmentAdapter extends EnumRowAdapter {

    private PsychosocialViewModel mViewModel;

    public PsychosocialFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       PsychosocialViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        PsychosocialRowViewModel specialNeedsRowViewModel = new PsychosocialRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(specialNeedsRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
