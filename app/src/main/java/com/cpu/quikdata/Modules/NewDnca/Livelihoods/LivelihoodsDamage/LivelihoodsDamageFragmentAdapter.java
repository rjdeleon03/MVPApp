package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row.LivelihoodsDamageRowViewModel;

public class LivelihoodsDamageFragmentAdapter extends BaseEnumRowAdapter {

    private LivelihoodsDamageViewModel mViewModel;

    public LivelihoodsDamageFragmentAdapter(Context context,
                                            BaseEnumNavigator baseEnumNavigator,
                                            LivelihoodsDamageViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
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
