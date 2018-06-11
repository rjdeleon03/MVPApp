package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewModel;
import com.cpu.quikdata.databinding.HealthDiseasesInjuriesRowBinding;
import com.cpu.quikdata.R;

public class DiseasesInjuriesFragmentAdapter extends RecyclerView.Adapter<DiseasesInjuriesRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private DiseasesInjuriesViewModel mViewModel;
    private Context mContext;

    public DiseasesInjuriesFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                           DiseasesInjuriesViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public DiseasesInjuriesRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.health_diseases_injuries_row, parent, false);
        HealthDiseasesInjuriesRowBinding binding = HealthDiseasesInjuriesRowBinding.bind(root);
        return new DiseasesInjuriesRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DiseasesInjuriesRowViewHolder holder, int position) {
        DiseasesInjuriesRowViewModel diseasesInjuriesRowViewModel = new DiseasesInjuriesRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(diseasesInjuriesRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
