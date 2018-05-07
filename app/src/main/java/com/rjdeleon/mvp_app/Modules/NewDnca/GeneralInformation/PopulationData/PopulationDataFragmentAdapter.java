package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewModel;
import com.rjdeleon.mvp_app.databinding.PopulationDataRowBinding;
import com.rjdeleon.mvp_app.R;

public class PopulationDataFragmentAdapter extends RecyclerView.Adapter<PopulationDataRowViewHolder> {

    private PopulationDataNavigator mPopulationDataNavigator;

    public PopulationDataFragmentAdapter(PopulationDataNavigator populationDataNavigator) {
        mPopulationDataNavigator = populationDataNavigator;
    }

    @NonNull
    @Override
    public PopulationDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PopulationDataRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_row, parent, false);
        return new PopulationDataRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulationDataRowViewHolder holder, int position) {
        PopulationDataRowViewModel populationDataRowViewModel = new PopulationDataRowViewModel();
        populationDataRowViewModel.setPopulationDataNavigator(mPopulationDataNavigator);
        holder.bind(populationDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
