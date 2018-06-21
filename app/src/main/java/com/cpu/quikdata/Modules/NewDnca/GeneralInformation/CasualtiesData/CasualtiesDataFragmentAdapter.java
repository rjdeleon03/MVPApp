package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewModel;

public class CasualtiesDataFragmentAdapter extends EnumRowAdapter {

    private CasualtiesDataViewModel mViewModel;

    public CasualtiesDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         CasualtiesDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        CasualtiesDataRowViewModel casualtiesDataRowViewModel = new CasualtiesDataRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(casualtiesDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
