package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row.LivelihoodsDamageRowViewModel;

public class LivelihoodsDamageFragmentAdapter extends EnumRowAdapter {

    private LivelihoodsDamageViewModel mViewModel;

    public LivelihoodsDamageFragmentAdapter(Context context,
                                            BaseEnumNavigator baseEnumNavigator,
                                            LivelihoodsDamageViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        LivelihoodsDamageRowViewModel livelihoodsDamageRowViewModel = new LivelihoodsDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(livelihoodsDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
