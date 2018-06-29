package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewModel;

public class DiseasesInjuriesFragmentAdapter extends BaseEnumRowAdapter {

    private DiseasesInjuriesViewModel mViewModel;

    public DiseasesInjuriesFragmentAdapter(Context context,
                                           BaseEnumNavigator baseEnumNavigator,
                                           DiseasesInjuriesViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseEnumRowViewHolder holder, int position) {
        DiseasesInjuriesRowViewModel diseasesInjuriesRowViewModel = new DiseasesInjuriesRowViewModel(
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
