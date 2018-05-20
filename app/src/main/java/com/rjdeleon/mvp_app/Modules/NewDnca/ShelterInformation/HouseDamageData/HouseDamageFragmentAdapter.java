package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.Row.HouseDamageRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.Row.HouseDamageRowViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.HouseDamageRowBinding;

public class HouseDamageFragmentAdapter extends RecyclerView.Adapter<HouseDamageRowViewHolder> {

    private BaseEnumNavigator mBaseEnumNavigator;
    private HouseDamageViewModel mViewModel;
    private Context mContext;

    public HouseDamageFragmentAdapter(Context context,
                                         BaseEnumNavigator baseEnumNavigator,
                                         HouseDamageViewModel viewModel) {

        mContext = context;
        mBaseEnumNavigator = baseEnumNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public HouseDamageRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.house_damage_row, parent, false);
        HouseDamageRowBinding binding = HouseDamageRowBinding.bind(root);
        return new HouseDamageRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull HouseDamageRowViewHolder holder, int position) {
        HouseDamageRowViewModel houseDamageRowViewModel = new HouseDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseEnumNavigator,
                position);
        holder.bind(houseDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
