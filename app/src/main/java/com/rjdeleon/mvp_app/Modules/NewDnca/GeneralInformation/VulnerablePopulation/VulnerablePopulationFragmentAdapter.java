package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row.VulnerablePopulationRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row.VulnerablePopulationRowViewModel;
import com.rjdeleon.mvp_app.databinding.VulnerablePopulationRowBinding;
import com.rjdeleon.mvp_app.R;

public class VulnerablePopulationFragmentAdapter extends RecyclerView.Adapter<VulnerablePopulationRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private VulnerablePopulationViewModel mViewModel;
    private Context mContext;

    public VulnerablePopulationFragmentAdapter(Context context,
                                               BaseEnumNavigator baseEnumNavigator,
                                               VulnerablePopulationViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public VulnerablePopulationRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.vulnerable_population_row, parent, false);
        VulnerablePopulationRowBinding binding = VulnerablePopulationRowBinding.bind(root);
        return new VulnerablePopulationRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VulnerablePopulationRowViewHolder holder, int position) {
        VulnerablePopulationRowViewModel vulnerablePopulationRowViewModel = new VulnerablePopulationRowViewModel(mContext, mViewModel, mBaseEnumNavigator, position);
        holder.bind(vulnerablePopulationRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
