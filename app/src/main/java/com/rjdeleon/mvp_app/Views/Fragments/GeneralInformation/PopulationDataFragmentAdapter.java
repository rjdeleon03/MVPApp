package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.PopulationDataPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataRowBinding;

public class PopulationDataFragmentAdapter extends RecyclerView.Adapter<PopulationDataFragmentViewHolder> {

    private PopulationDataContract.Presenter mPresenter;

    public PopulationDataFragmentAdapter(PopulationDataPresenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public PopulationDataFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PopulationDataRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_row, parent, false);
        return new PopulationDataFragmentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulationDataFragmentViewHolder holder, int position) {
        mPresenter.onBindItemViewAtPosition(holder, position);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getPopulationDataRowsCount();
    }
}
