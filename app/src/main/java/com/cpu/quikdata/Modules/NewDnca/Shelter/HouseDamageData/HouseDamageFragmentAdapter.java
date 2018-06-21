package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Row.HouseDamageRowViewModel;

public class HouseDamageFragmentAdapter extends BaseEnumRowAdapter {

    private HouseDamageViewModel mViewModel;

    public HouseDamageFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         HouseDamageViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        HouseDamageRowViewModel houseDamageRowViewModel = new HouseDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(houseDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
