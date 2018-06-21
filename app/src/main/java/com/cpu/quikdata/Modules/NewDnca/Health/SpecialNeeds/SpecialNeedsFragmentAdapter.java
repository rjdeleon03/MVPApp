package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row.SpecialNeedsRowViewModel;

public class SpecialNeedsFragmentAdapter extends BaseEnumRowAdapter {

    private SpecialNeedsViewModel mViewModel;

    public SpecialNeedsFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       SpecialNeedsViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        SpecialNeedsRowViewModel specialNeedsRowViewModel = new SpecialNeedsRowViewModel(
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
