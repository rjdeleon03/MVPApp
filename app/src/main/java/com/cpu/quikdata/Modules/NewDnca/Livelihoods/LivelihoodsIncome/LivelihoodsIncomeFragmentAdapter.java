package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row.LivelihoodsIncomeRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsIncome.Row.LivelihoodsIncomeRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.LivelihoodsIncomeSourceRowBinding;

public class LivelihoodsIncomeFragmentAdapter extends RecyclerView.Adapter<LivelihoodsIncomeRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private LivelihoodsIncomeViewModel mViewModel;

    public LivelihoodsIncomeFragmentAdapter(Context context,
                                            BaseEnumNavigator baseEnumNavigator,
                                            LivelihoodsIncomeViewModel viewModel) {
        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public LivelihoodsIncomeRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.livelihoods_income_source_row, parent, false);
        LivelihoodsIncomeSourceRowBinding binding = LivelihoodsIncomeSourceRowBinding.bind(root);
        return new LivelihoodsIncomeRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LivelihoodsIncomeRowViewHolder holder, int position) {
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
