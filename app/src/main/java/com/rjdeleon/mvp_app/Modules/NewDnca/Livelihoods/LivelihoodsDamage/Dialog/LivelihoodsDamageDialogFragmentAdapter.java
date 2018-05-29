package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxParentViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxViewHolder;
import com.rjdeleon.mvp_app.databinding.BaseCheckboxBinding;
import com.rjdeleon.mvp_app.R;

public class LivelihoodsDamageDialogFragmentAdapter extends RecyclerView.Adapter<LivelihoodsDamageCheckboxViewHolder> {

    private LivelihoodsDamageCheckboxParentViewModel mViewModel;

    public LivelihoodsDamageDialogFragmentAdapter(LivelihoodsDamageCheckboxParentViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public LivelihoodsDamageCheckboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.base_checkbox, parent, false);
        BaseCheckboxBinding binding = BaseCheckboxBinding.bind(root);
        return new LivelihoodsDamageCheckboxViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LivelihoodsDamageCheckboxViewHolder holder, int position) {
        holder.bind(mViewModel.getAffectedLivelihoodViewModel(position));
    }

    @Override
    public int getItemCount() {
        return mViewModel.getAffectedLivelihoodsCount();
    }
}
