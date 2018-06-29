package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row.PsychosocialRowViewModel;

public class PsychosocialFragmentAdapter extends BaseEnumRowAdapter {

    private PsychosocialViewModel mViewModel;

    public PsychosocialFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       PsychosocialViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        PsychosocialRowViewModel specialNeedsRowViewModel = new PsychosocialRowViewModel(
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
