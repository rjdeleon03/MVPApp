package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewModel;

public class ShelterNeedsFragmentAdapter extends EnumRowAdapter {

    private ShelterNeedsViewModel mViewModel;

    public ShelterNeedsFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       ShelterNeedsViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        ShelterNeedsRowViewModel shelterNeedsRowViewModel = new ShelterNeedsRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(shelterNeedsRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
