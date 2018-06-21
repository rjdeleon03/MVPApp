package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row.SpecialNeedsRowViewModel;

public class SpecialNeedsFragmentAdapter extends EnumRowAdapter {

    private SpecialNeedsViewModel mViewModel;

    public SpecialNeedsFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       SpecialNeedsViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
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
