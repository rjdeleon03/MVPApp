package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.BaseAgeGroupNavigator;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Row.CasualtiesDataRowViewModel;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.CasualtiesDataRowBinding;

public class CasualtiesDataFragmentAdapter extends RecyclerView.Adapter<CasualtiesDataRowViewHolder> {

    private BaseAgeGroupNavigator mBaseAgeGroupNavigator;
    private CasualtiesDataViewModel mViewModel;
    private Context mContext;

    public CasualtiesDataFragmentAdapter(Context context,
                                         BaseAgeGroupNavigator baseAgeGroupNavigator,
                                         CasualtiesDataViewModel viewModel) {

        mContext = context;
        mBaseAgeGroupNavigator = baseAgeGroupNavigator;
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public CasualtiesDataRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View root = inflater.inflate(R.layout.casualties_data_row, parent, false);
        CasualtiesDataRowBinding binding = CasualtiesDataRowBinding.bind(root);
        return new CasualtiesDataRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CasualtiesDataRowViewHolder holder, int position) {
        CasualtiesDataRowViewModel casualtiesDataRowViewModel = new CasualtiesDataRowViewModel(
                mContext,
                mViewModel,
                mBaseAgeGroupNavigator,
                position);
        holder.bind(casualtiesDataRowViewModel);
    }

    @Override
    public int getItemCount() {
        return mViewModel.getDataRowsCount();
    }
}
