package com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseCheckbox;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;

public class BaseCheckboxAdapter extends RecyclerView.Adapter {

    private BaseCheckboxViewModel mViewModel;

    public BaseCheckboxAdapter(BaseCheckboxViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseCheckboxItemViewModel baseCheckboxItemViewModel = new BaseCheckboxItemViewModel(
                mViewModel,
                position);
        holder.bind(baseCheckboxItemViewModel);

    }

    @Override
    public int getItemCount() {
        return mParentViewModel.getCheckboxesCount();
    }

    public class BaseCheckboxViewHolder extends RecyclerView.ViewHolder {

        private PopulationDataRowBinding mBinding;

        public PopulationDataRowViewHolder(PopulationDataRowBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(BaseCheckboxItemViewModel baseCheckboxItemViewModel) {
            mBinding.setViewModel(baseCheckboxItemViewModel);
        }
    }
}
