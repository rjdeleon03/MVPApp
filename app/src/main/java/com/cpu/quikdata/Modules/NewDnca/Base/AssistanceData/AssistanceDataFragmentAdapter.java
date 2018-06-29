package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;

public class AssistanceDataFragmentAdapter extends BaseEnumRowAdapter {

    private AssistanceDataViewModel mViewModel;

    public AssistanceDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         AssistanceDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        AssistanceRowViewModel assistanceRowViewModel = new AssistanceRowViewModel(
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
