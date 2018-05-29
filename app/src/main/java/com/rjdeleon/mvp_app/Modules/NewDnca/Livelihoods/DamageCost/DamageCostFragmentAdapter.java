package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Row.DamageCostRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Row.DamageCostRowViewModel;
import com.rjdeleon.mvp_app.databinding.LivelihoodsDamageRowBinding;
import com.rjdeleon.mvp_app.R;

public class DamageCostFragmentAdapter extends RecyclerView.Adapter<DamageCostRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private DamageCostViewModel mViewModel;

    public DamageCostFragmentAdapter(Context context,
                                     BaseEnumNavigator baseEnumNavigator,
                                     DamageCostViewModel viewModel) {
        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public DamageCostRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.livelihoods_damage_row, parent, false);
        LivelihoodsDamageRowBinding binding = LivelihoodsDamageRowBinding.bind(root);
        return new DamageCostRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DamageCostRowViewHolder holder, int position) {
        DamageCostRowViewModel damageCostRowViewModel = new DamageCostRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(damageCostRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
