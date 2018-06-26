package com.cpu.quikdata.Modules.NewDnca.EvacuationList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.EvacuationList.EvacuationListItem.EvacuationListItemViewHolder;
import com.cpu.quikdata.Modules.NewDnca.EvacuationList.EvacuationListItem.EvacuationListItemViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.EvacuationListItemBinding;

public class EvacuationListAdapter extends RecyclerView.Adapter<EvacuationListItemViewHolder>{

    private EvacuationListViewModel mViewModel;

    public EvacuationListAdapter(EvacuationListViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public EvacuationListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.evacuation_list_item, parent, false);
        EvacuationListItemBinding binding = EvacuationListItemBinding.bind(root);

        EvacuationListItemViewModel viewModel = new EvacuationListItemViewModel(parent.getContext().getApplicationContext());
        binding.setViewModel(viewModel);
        return new EvacuationListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EvacuationListItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
