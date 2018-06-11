package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Row.HouseDamageRowViewHolder;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Row.HouseDamageRowViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.ShelterHouseDamageRowBinding;

public class HouseDamageFragmentAdapter extends RecyclerView.Adapter<HouseDamageRowViewHolder> {

    private Context mContext;
    private BaseEnumNavigator mBaseEnumNavigator;
    private HouseDamageViewModel mViewModel;

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
        View root = inflater.inflate(R.layout.shelter_house_damage_row, parent, false);
        ShelterHouseDamageRowBinding binding = ShelterHouseDamageRowBinding.bind(root);
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
