package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewModel;

public class CasualtiesDataFragmentAdapter extends BaseEnumRowAdapter {

    private CasualtiesDataViewModel mViewModel;

    public CasualtiesDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         CasualtiesDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        CasualtiesDataRowViewModel casualtiesDataRowViewModel = new CasualtiesDataRowViewModel(
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
