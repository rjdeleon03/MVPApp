package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row.LivelihoodsIncomeRowViewModel;

public class LivelihoodsIncomeFragmentAdapter extends BaseEnumRowAdapter {

    private LivelihoodsIncomeViewModel mViewModel;

    public LivelihoodsIncomeFragmentAdapter(Context context,
                                            BaseEnumNavigator baseEnumNavigator,
                                            LivelihoodsIncomeViewModel viewModel) {
        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        LivelihoodsIncomeRowViewModel livelihoodsIncomeRowViewModel = new LivelihoodsIncomeRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(livelihoodsIncomeRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
