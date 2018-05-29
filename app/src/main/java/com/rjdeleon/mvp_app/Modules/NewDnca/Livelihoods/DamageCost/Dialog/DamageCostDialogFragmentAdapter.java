package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostFragmentAdapter;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox.DamageCostCheckboxParentViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox.DamageCostCheckboxViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox.DamageCostCheckboxViewModel;
import com.rjdeleon.mvp_app.databinding.BaseCheckboxBinding;
import com.rjdeleon.mvp_app.R;

public class DamageCostDialogFragmentAdapter extends RecyclerView.Adapter<DamageCostCheckboxViewHolder> {

    private DamageCostCheckboxParentViewModel mViewModel;

    public DamageCostDialogFragmentAdapter(DamageCostCheckboxParentViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public DamageCostCheckboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.base_checkbox, parent, false);
        BaseCheckboxBinding binding = BaseCheckboxBinding.bind(root);
        return new DamageCostCheckboxViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DamageCostCheckboxViewHolder holder, int position) {
        holder.bind(mViewModel.getAffectedLivelihoodViewModel(position));
    }

    @Override
    public int getItemCount() {
        return mViewModel.getAffectedLivelihoodsCount();
    }
}
