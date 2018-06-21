package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;

public class AssistanceDataFragmentAdapter extends EnumRowAdapter {

    private AssistanceDataViewModel mViewModel;

    public AssistanceDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         AssistanceDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        AssistanceRowViewModel assistanceRowViewModel = new AssistanceRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(assistanceRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
