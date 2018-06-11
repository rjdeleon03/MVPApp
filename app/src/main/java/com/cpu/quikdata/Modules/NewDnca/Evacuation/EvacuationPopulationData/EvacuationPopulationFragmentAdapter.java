package com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Row.EvacuationPopulationRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationPopulationData.Row.EvacuationPopulationRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.EvacuationPopulationRowBinding;

public class EvacuationPopulationFragmentAdapter extends RecyclerView.Adapter<EvacuationPopulationRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private EvacuationPopulationViewModel mViewModel;
    private Context mContext;

    public EvacuationPopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               EvacuationPopulationViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public EvacuationPopulationRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.evacuation_population_row, parent, false);
        EvacuationPopulationRowBinding binding = EvacuationPopulationRowBinding.bind(root);
        return new EvacuationPopulationRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EvacuationPopulationRowViewHolder holder, int position) {
        EvacuationPopulationRowViewModel evacuationPopulationRowViewModel = new EvacuationPopulationRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(evacuationPopulationRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
