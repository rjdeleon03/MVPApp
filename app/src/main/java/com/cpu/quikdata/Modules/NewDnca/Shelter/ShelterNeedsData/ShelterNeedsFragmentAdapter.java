package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewModel;
import com.cpu.quikdata.databinding.ShelterNeedsRowBinding;
import com.cpu.quikdata.R;

public class ShelterNeedsFragmentAdapter extends RecyclerView.Adapter<ShelterNeedsRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private ShelterNeedsViewModel mViewModel;

    public ShelterNeedsFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       ShelterNeedsViewModel viewModel) {
        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public ShelterNeedsRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.shelter_needs_row, parent, false);
        ShelterNeedsRowBinding binding = ShelterNeedsRowBinding.bind(root);
        return new ShelterNeedsRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShelterNeedsRowViewHolder holder, int position) {
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
