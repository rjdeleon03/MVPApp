package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Row.DeathCauseDataRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.DeathCauseData.Row.DeathCauseDataRowViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.DeathCauseDataRowBinding;

public class DeathCauseDataFragmentAdapter extends RecyclerView.Adapter<DeathCauseDataRowViewHolder> {

    private BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    private DeathCauseDataViewModel mViewModel;
    private Context mContext;

    public DeathCauseDataFragmentAdapter(Context context,
                                         BaseAgeGroupNavigator baseAgeGroupNavigator,
                                         DeathCauseDataViewModel viewModel) {

        mContext = context;
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public DeathCauseDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.death_cause_data_row, parent, false);
        DeathCauseDataRowBinding binding = DeathCauseDataRowBinding.bind(root);
        return new DeathCauseDataRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeathCauseDataRowViewHolder holder, int position) {
        DeathCauseDataRowViewModel deathCauseDataRowViewModel = new DeathCauseDataRowViewModel(
                mContext,
                mViewModel,
                mBaseAgeGroupNavigator,
                position);
        holder.bind(deathCauseDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
