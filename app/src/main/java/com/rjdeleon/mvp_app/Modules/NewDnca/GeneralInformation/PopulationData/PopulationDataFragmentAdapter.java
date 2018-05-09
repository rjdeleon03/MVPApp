package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Injection;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Row.PopulationDataRowViewModel;
import com.rjdeleon.mvp_app.databinding.PopulationDataRowBinding;
import com.rjdeleon.mvp_app.R;

public class PopulationDataFragmentAdapter extends RecyclerView.Adapter<PopulationDataRowViewHolder> {

    private PopulationDataNavigator mPopulationDataNavigator;
    private PopulationDataViewModel mViewModel;
    private Context mContext;

    public PopulationDataFragmentAdapter(Context context, PopulationDataNavigator populationDataNavigator, PopulationDataViewModel viewModel) {
        mPopulationDataNavigator = populationDataNavigator;
        mContext = context;
        mViewModel = viewModel;
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
        PopulationDataRowViewModel populationDataRowViewModel = new PopulationDataRowViewModel(
                mContext,
                mViewModel,
                position
        );
        holder.bind(populationDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getPopulationDataRowsCount();
    }
}
