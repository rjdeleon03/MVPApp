package com.cpu.quikdata.Modules.NewDnca.Evacuation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Models.DNCAListItem;
import com.cpu.quikdata.Models.Evacuation.EvacuationInfo;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.EvacuationListItemBinding;

import java.util.List;

public class EvacuationListAdapter extends RecyclerView.Adapter<EvacuationListItemViewHolder>{

    private com.cpu.quikdata.Modules.NewDnca.Evacuation.EvacuationListViewModel mViewModel;

    public EvacuationListAdapter(EvacuationListViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public EvacuationListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.evacuation_list_item, parent, false);
        EvacuationListItemBinding binding = EvacuationListItemBinding.bind(root);
        return new EvacuationListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EvacuationListItemViewHolder holder, int position) {
        EvacuationListItemViewModel viewModel = new EvacuationListItemViewModel(mViewModel.getEvacuationInfo(position));
        holder.bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getEvacuationInfos().size();
    }

    /**
     * Replace DNCA list items to update
     * @param items
     */
    public void replaceItems(List<EvacuationInfo> items) {
        mViewModel.saveEvacuationInfos(items);
        notifyDataSetChanged();
    }
}
