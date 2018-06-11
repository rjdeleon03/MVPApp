package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row.LivelihoodsDamageRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row.LivelihoodsDamageRowViewModel;
import com.cpu.quikdata.databinding.LivelihoodsDamageRowBinding;
import com.cpu.quikdata.R;

public class LivelihoodsDamageFragmentAdapter extends RecyclerView.Adapter<LivelihoodsDamageRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private LivelihoodsDamageViewModel mViewModel;

    public LivelihoodsDamageFragmentAdapter(Context context,
                                            BaseEnumNavigator baseEnumNavigator,
                                            LivelihoodsDamageViewModel viewModel) {
        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public LivelihoodsDamageRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.livelihoods_damage_row, parent, false);
        LivelihoodsDamageRowBinding binding = LivelihoodsDamageRowBinding.bind(root);
        return new LivelihoodsDamageRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LivelihoodsDamageRowViewHolder holder, int position) {
        LivelihoodsDamageRowViewModel livelihoodsDamageRowViewModel = new LivelihoodsDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(livelihoodsDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
