package com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewModel;
import com.rjdeleon.mvp_app.databinding.ShelterNeedsRowBinding;
import com.rjdeleon.mvp_app.R;

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
