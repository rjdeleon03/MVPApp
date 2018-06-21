package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewModel;

public class DiseasesInjuriesFragmentAdapter extends EnumRowAdapter {

    private DiseasesInjuriesViewModel mViewModel;

    public DiseasesInjuriesFragmentAdapter(Context context,
                                           BaseEnumNavigator baseEnumNavigator,
                                           DiseasesInjuriesViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        DiseasesInjuriesRowViewModel diseasesInjuriesRowViewModel = new DiseasesInjuriesRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(diseasesInjuriesRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
