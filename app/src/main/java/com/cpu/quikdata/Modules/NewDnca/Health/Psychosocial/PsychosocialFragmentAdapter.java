package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row.PsychosocialRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row.PsychosocialRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.HealthPsychosocialRowBinding;

public class PsychosocialFragmentAdapter extends RecyclerView.Adapter<PsychosocialRowViewHolder> {
    
    private BaseEnumNavigator mBaseEnumNavigator;
    private PsychosocialViewModel mViewModel;
    private Context mContext;

    public PsychosocialFragmentAdapter(Context context,
                                       BaseEnumNavigator baseEnumNavigator,
                                       PsychosocialViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public PsychosocialRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.health_psychosocial_row, parent, false);
        HealthPsychosocialRowBinding binding = HealthPsychosocialRowBinding.bind(root);
        return new PsychosocialRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PsychosocialRowViewHolder holder, int position) {
        PsychosocialRowViewModel specialNeedsRowViewModel = new PsychosocialRowViewModel(
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
