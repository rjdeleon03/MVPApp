package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row.SpecialNeedsRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row.SpecialNeedsRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.HealthSpecialNeedsRowBinding;

public class SpecialNeedsFragmentAdapter extends RecyclerView.Adapter<SpecialNeedsRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private SpecialNeedsViewModel mViewModel;
    private Context mContext;

    public SpecialNeedsFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       SpecialNeedsViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public SpecialNeedsRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.health_special_needs_row, parent, false);
        HealthSpecialNeedsRowBinding binding = HealthSpecialNeedsRowBinding.bind(root);
        return new SpecialNeedsRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialNeedsRowViewHolder holder, int position) {
        SpecialNeedsRowViewModel specialNeedsRowViewModel = new SpecialNeedsRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(specialNeedsRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
