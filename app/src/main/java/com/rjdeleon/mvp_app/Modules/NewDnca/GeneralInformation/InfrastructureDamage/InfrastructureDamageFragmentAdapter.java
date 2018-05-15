package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row.InfrastructureDamageRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.InfrastructureDamage.Row.InfrastructureDamageRowViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.InfrastructureDamageRowBinding;

public class InfrastructureDamageFragmentAdapter extends RecyclerView.Adapter<InfrastructureDamageRowViewHolder> {

    private BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    private InfrastructureDamageViewModel mViewModel;
    private Context mContext;

    public InfrastructureDamageFragmentAdapter(Context context,
                                               BaseAgeGroupNavigator baseAgeGroupNavigator,
                                               InfrastructureDamageViewModel viewModel) {

        mContext = context;
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public InfrastructureDamageRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.infrastructure_damage_row, parent, false);
        InfrastructureDamageRowBinding binding = InfrastructureDamageRowBinding.bind(root);
        return new InfrastructureDamageRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InfrastructureDamageRowViewHolder holder, int position) {
        InfrastructureDamageRowViewModel infrastructureDamageRowViewModel = new InfrastructureDamageRowViewModel(
                mContext,
                mViewModel,
                mBaseAgeGroupNavigator,
                position);
        holder.bind(infrastructureDamageRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
