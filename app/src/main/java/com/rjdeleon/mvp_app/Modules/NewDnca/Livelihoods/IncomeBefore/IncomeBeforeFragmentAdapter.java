package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.Row.IncomeBeforeRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.IncomeBefore.Row.IncomeBeforeRowViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.IncomeSourceRowBinding;

public class IncomeBeforeFragmentAdapter extends RecyclerView.Adapter<IncomeBeforeRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private IncomeBeforeViewModel mViewModel;

    public IncomeBeforeFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       IncomeBeforeViewModel viewModel) {
        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public IncomeBeforeRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.income_source_row, parent, false);
        IncomeSourceRowBinding binding = IncomeSourceRowBinding.bind(root);
        return new IncomeBeforeRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeBeforeRowViewHolder holder, int position) {
        IncomeBeforeRowViewModel incomeBeforeRowViewModel = new IncomeBeforeRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(incomeBeforeRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
