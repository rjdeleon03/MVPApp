package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View.EnumRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumRowBinding;

public class PopulationDataFragmentAdapter extends EnumRowAdapter {

    private PopulationDataViewModel mViewModel;

    public PopulationDataFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         PopulationDataViewModel viewModel) {

        super(context, baseEnumNavigator);
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull EnumRowViewHolder holder, int position) {
        PopulationDataRowViewModel populationDataRowViewModel = new PopulationDataRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(populationDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
